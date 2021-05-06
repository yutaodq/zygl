package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder()
public class VehicleStateUpdateEvent {

    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
    private VehicleStateId vehicleStateId;

    String description; // 备注

}
