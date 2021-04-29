package mike.wolf.zygl.vehicle.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.vehicle.state.CreateVehicleStateCommand;
import mike.wolf.zygl.api.vehicle.state.StateName;
import mike.wolf.zygl.api.vehicle.state.VehicleStateCreateEvent;
import mike.wolf.zygl.api.vehicle.state.VehicleStateId;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Aggregate
@Profile("command")
public class VehicleState {

    @AggregateIdentifier
    private VehicleStateId vehicleStateId;
    private StateName name;  //状态名称
    private String description; // 备注

    @CommandHandler
    public VehicleState(CreateVehicleStateCommand cmd) {
        log.debug("handling {}", cmd);
        apply(VehicleStateCreateEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .stateName(cmd.getStateName())
                .description(cmd.getDescription())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleStateCreateEvent evt) {
        log.debug("applying {}", evt);
        vehicleStateId = evt.getVehicleStateId();
        name = evt.getStateName();
        description =  evt.getDescription();
    }

}