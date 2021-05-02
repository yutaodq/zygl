package mike.wolf.zygl.vehicle.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.vehicle.state.*;
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
//@Profile("command")
public class VehicleState {

    @AggregateIdentifier
    private VehicleStateId vehicleStateId;
    private StateName name;  //状态名称
    private String description; // 备注

    @CommandHandler
    public VehicleState(CreateVehicleStateCommand cmd) {
        log.info("VehicleState @Aggregate VehicleState(CreateVehicleStateCommand cmd) : {}", cmd.getStateName());
        apply(VehicleStateCreateEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .stateName(cmd.getStateName())
                .description(cmd.getDescription())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleStateCreateEvent event) {
        log.info("VehicleState @Aggregate void on(VehicleStateCreateEvent evt) : {}", event.getStateName());
        vehicleStateId = event.getVehicleStateId();
        name = event.getStateName();
        description =  event.getDescription();
    }
    @CommandHandler
    public void handle(DeleteVehicleStateCommand cmd) {
        log.info("VehicleState @Aggregate VehicleState(CreateVehicleStateCommand cmd) : {}", cmd.getVehicleStateId());
        apply(VehicleStateDeleteEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .build()
        );
    }


}
