package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import static com.google.common.base.Preconditions.checkNotNull;

@Value
@Builder()
public class VehicleStateCreateEvent {

    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
   private VehicleStateId vehicleStateId;

    @NotNull(message = "车辆状态名称对象不能为空")
    private StateName stateName;

    String description; // 备注

//    public VehicleStateCreateEvent(
//            VehicleStateId vehicleStateId,
//            StateName stateName,
//            String description) {
//        log.info("新建：ProductCreatedEvent");
//        this.vehicleStateId = checkNotNull(vehicleStateId, "没有车辆状态聚合标识符！");
//        this.stateName = checkNotNull(stateName, "没有车辆状态名称！");
//        this.description = description;
//    }

}
