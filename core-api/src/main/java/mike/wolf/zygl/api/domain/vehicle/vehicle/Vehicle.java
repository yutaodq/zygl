package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.CreateVehicleUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.VehicleCreateEvent;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Slf4j
@NoArgsConstructor
@Aggregate
public class Vehicle {

    @AggregateIdentifier
    private VehicleId vehicleId;
    private VehiclePz pz;  //牌照
    private VehicleNbpz bnpz; // 内部牌照
    private VehicleTypeId typeId;
    private VehicleStateId stateId;
    private String name;

    @CommandHandler
    public Vehicle(CreateVehicleUseCase.CreateVehicleCommand cmd) {
        log.info("Vehicle @Aggregate Vehicle(CreateVehicleCommand cmd) : {}", cmd.getName());
        apply(VehicleCreateEvent.builder()
                .vehicleId(cmd.getVehicleId())
                .name(cmd.getName())
                .ggxh(cmd.getGgxh())  //规格型号
                .pz(cmd.getPz())  //牌照号
                .nbpz(cmd.getNbpz())  //内部牌照号
                .sccj(cmd.getSccj())  //生产厂家
                .ccrq(cmd.getCcrq())  //出厂日期
                .tcrq(cmd.getTcrq())  //投产日期
                .yz(cmd.getYz())  //车辆原值
                .csys(cmd.getCsys())  //车身颜色
                .fdjxh(cmd.getFdjxh())  //发动机型号
                .fdjbh(cmd.getFdjbh())  //发动机编号
                .dpxh(cmd.getDpxh())  //底盘型号
                .dpbh(cmd.getDpbh())  //底盘编号
                .description(cmd.getDescription())
                .structure(cmd.getStructure())
                .parameter(cmd.getParameter())
                .special(cmd.getSpecial())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(VehicleCreateEvent event) {
        log.info("Vehicle @Aggregate void on(VehicleCreateEvent evt) : {}", event.getName());
        vehicleId = event.getVehicleId();
        name = event.getName();
    }
//    @CommandHandler
//    public void handle(DeleteVehicleCommand cmd) {
//        log.info("Vehicle @Aggregate Vehicle(DeleteVehicleCommand cmd) : {}", cmd.getVehicleId());
//        apply(VehicleDeleteEvent.builder()
//                .vehicleId(cmd.getVehicleId())
//                .build()
//        );
//    }
//
//    @EventSourcingHandler
//    public void on(VehicleDeleteEvent event) {
//        log.info("Vehicle @Aggregate void on(VehicleDeleteEvent evt) : {}", event.getVehicleId());
//        markDeleted();
//    }

//    @CommandHandler
//    public void handle(UpdateVehicleCommand cmd) {
//        log.info("Vehicle @Aggregate Vehicle(UpdateVehicleCommand cmd) : 修改命令");
//        apply(VehicleUpdateEvent.builder()
//                .vehicleId(cmd.getVehicleId())
//                .description(cmd.getDescription())
//                .build()
//        );
//    }
//
//    @EventSourcingHandler
//    public void on(VehicleUpdateEvent event) {
//        log.info("Vehicle @Aggregate void on(VehicleUpdateEvent evt) : {}", event.getVehicleId());
//        this.description= event.getDescription();
//    }
//
//    @CommandHandler
//    public void handle(UpdateVehicleNameCommand cmd) {
//        log.info("Vehicle @Aggregate Vehicle(UpdateVehicleNameCommand cmd) : 修改名称命令");
//        apply(VehicleUpdateNameEvent.builder()
//                .vehicleId(cmd.getVehicleId())
//                .typeName(cmd.getTypeName())
//                .build()
//        );
//    }
//
//    @EventSourcingHandler
//    public void on(VehicleUpdateNameEvent event) {
//        log.info("Vehicle @Aggregate void on(VehicleUpdateNameEvent evt) : 修改名称事件");
//        this.name= event.getTypeName();
//    }

}
