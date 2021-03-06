package mike.wolf.zygl.api.domain.vehicle.state;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.application.port.in.vehicle.state.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;

@Slf4j
@NoArgsConstructor
@Aggregate
public class VehicleState {

    @AggregateIdentifier
    private VehicleStateId vehicleStateId;
    private StateName name;  //状态名称
    private String description; // 备注

    @CommandHandler
    public VehicleState(CreateVehicleStateUseCase.CreateVehicleStateCommand cmd) {
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
    //删除记录
    @CommandHandler
    public void handle(DeleteVehicleStateUseCase.DeleteVehicleStateCommand cmd) {
        log.info("删除车辆状态命令 @Aggregate: {}", cmd.getVehicleStateId());
        apply(VehicleStateDeleteEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleStateDeleteEvent event) {
        log.info("删除车辆状态事件 @Aggregate void on(VehicleStateDeleteEvent evt) : {}", event.getVehicleStateId());
        markDeleted();
    }
//修改
    @CommandHandler
    public void handle(UpdateVehicleStateUseCase.UpdateVehicleStateCommand cmd) {
        log.info("VehicleState @Aggregate VehicleState(UpdateVehicleStateCommand cmd) : 修改命令");
        apply(VehicleStateUpdateEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .description(cmd.getDescription())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleStateUpdateEvent event) {
        log.info("VehicleState @Aggregate void on(VehicleStateUpdateEvent evt) : {}", event.getVehicleStateId());
        this.description= event.getDescription();
    }
//修改名称
    @CommandHandler
    public void handle(UpdateVehicleStateNameUseCase.UpdateVehicleStateNameCommand cmd) {
        log.info("VehicleState @Aggregate VehicleState(UpdateVehicleStateNameCommand cmd) : 修改名称命令");
        apply(VehicleStateUpdateNameEvent.builder()
                .vehicleStateId(cmd.getVehicleStateId())
                .stateName(cmd.getStateName())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleStateUpdateNameEvent event) {
        log.info("VehicleState @Aggregate void on(VehicleStateUpdateNameEvent evt) : 修改名称事件");
        this.name= event.getStateName();
    }

}
