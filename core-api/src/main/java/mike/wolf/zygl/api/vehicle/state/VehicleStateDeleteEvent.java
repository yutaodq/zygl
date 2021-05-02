package mike.wolf.zygl.api.vehicle.state;

import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder()
public class VehicleStateDeleteEvent {

    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
    VehicleStateId vehicleStateId;

}
