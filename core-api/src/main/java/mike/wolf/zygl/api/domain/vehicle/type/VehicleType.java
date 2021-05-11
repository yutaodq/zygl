package mike.wolf.zygl.api.domain.vehicle.type;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.application.port.in.vehicle.type.CreateVehicleTypeUseCase.CreateVehicleTypeCommand;
import mike.wolf.zygl.api.application.port.in.vehicle.type.DeleteVehicleTypeUseCase.DeleteVehicleTypeCommand;
import mike.wolf.zygl.api.application.port.in.vehicle.type.VehicleTypeCreateEvent;
import mike.wolf.zygl.api.application.port.in.vehicle.type.VehicleTypeDeleteEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.markDeleted;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@NoArgsConstructor
@Aggregate
public class VehicleType {

    @AggregateIdentifier
    private VehicleTypeId vehicleTypeId;
    private TypeName name;  //状态名称
    private String description; // 备注

    @CommandHandler
    public VehicleType(CreateVehicleTypeCommand cmd) {
        log.info("VehicleType @Aggregate VehicleType(CreateVehicleTypeCommand cmd) : {}", cmd.getTypeName());
        apply(VehicleTypeCreateEvent.builder()
                .vehicleTypeId(cmd.getVehicleTypeId())
                .typeName(cmd.getTypeName())
                .description(cmd.getDescription())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleTypeCreateEvent event) {
        log.info("VehicleType @Aggregate void on(VehicleTypeCreateEvent evt) : {}", event.getTypeName());
        vehicleTypeId = event.getVehicleTypeId();
        name = event.getTypeName();
        description =  event.getDescription();
    }
    @CommandHandler
    public void handle(DeleteVehicleTypeCommand cmd) {
        log.info("VehicleType @Aggregate VehicleType(DeleteVehicleTypeCommand cmd) : {}", cmd.getVehicleTypeId());
        apply(VehicleTypeDeleteEvent.builder()
                .vehicleTypeId(cmd.getVehicleTypeId())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleTypeDeleteEvent event) {
        log.info("VehicleType @Aggregate void on(VehicleTypeDeleteEvent evt) : {}", event.getVehicleTypeId());
        markDeleted();
    }

//    @CommandHandler
//    public void handle(UpdateVehicleTypeCommand cmd) {
//        log.info("VehicleType @Aggregate VehicleType(UpdateVehicleTypeCommand cmd) : 修改命令");
//        apply(VehicleTypeUpdateEvent.builder()
//                .vehicleStateId(cmd.getVehicleTypeId())
//                .description(cmd.getDescription())
//                .build()
//        );
//    }
//
//    @EventSourcingHandler
//    public void on(VehicleTypeUpdateEvent event) {
//        log.info("VehicleType @Aggregate void on(VehicleTypeUpdateEvent evt) : {}", event.getVehicleTypeId());
//        this.description= event.getDescription();
//    }
//
//    @CommandHandler
//    public void handle(UpdateVehicleTypeNameCommand cmd) {
//        log.info("VehicleType @Aggregate VehicleType(UpdateVehicleTypeNameCommand cmd) : 修改名称命令");
//        apply(VehicleTypeUpdateNameEvent.builder()
//                .vehicleStateId(cmd.getVehicleTypeId())
//                .stateName(cmd.getStateName())
//                .build()
//        );
//    }
//
//    @EventSourcingHandler
//    public void on(VehicleTypeUpdateNameEvent event) {
//        log.info("VehicleType @Aggregate void on(VehicleTypeUpdateNameEvent evt) : 修改名称事件");
//        this.name= event.getStateName();
//    }

}
