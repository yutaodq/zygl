package mike.wolf.zygl.vehicle.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.vehicle.state.CreateVehicleStateCommand;
import mike.wolf.zygl.api.vehicle.state.VehicleStateCreateEvent;
import mike.wolf.zygl.api.vehicle.state.VehicleStateId;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Aggregate
@Profile("command")
@Slf4j
public class VehicleState {

    @AggregateIdentifier
    private VehicleStateId id;
    private String name;  //状态名称
    private String description; // 备注

    @CommandHandler
    public VehicleState(CreateVehicleStateCommand cmd) {
        log.debug("handling {}", cmd);
         apply(new VehicleStateCreateEvent(cmd.getId(), cmd.getAmount()));
    }


}
