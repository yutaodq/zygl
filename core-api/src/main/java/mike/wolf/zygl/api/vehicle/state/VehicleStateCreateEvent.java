package mike.wolf.zygl.api.vehicle.state;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
@Getter
@Builder()
public class VehicleStateCreateEvent {

    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
    VehicleStateId vehicleStateId;

    @NotNull(message = "车辆状态名称对象不能为空")
    StateName stateName;

    String description; // 备注

    public VehicleStateCreateEvent(
            VehicleStateId vehicleStateId,
            StateName stateName,
            String description) {
        log.info("新建：ProductCreatedEvent");
        this.vehicleStateId = checkNotNull(vehicleStateId, "没有车辆状态聚合标识符！");
        this.stateName = checkNotNull(stateName, "没有车辆状态名称！");
    }

//    public static VehicleStateCreateEvent create(
//            VehicleStateId vehicleStateId,
//            StateName stateName,
//            String description) {
//        return new VehicleStateCreateEvent(
//                vehicleStateId,
//                stateName,
//                description);
//    }

}
