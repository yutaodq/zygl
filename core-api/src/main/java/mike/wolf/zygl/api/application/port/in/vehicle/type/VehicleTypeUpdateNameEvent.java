package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder()
public class VehicleTypeUpdateNameEvent {
    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
    private VehicleTypeId vehicleTypeId;

    @NotNull(message = "状态名称不能为空")
    TypeName typeName;

}
