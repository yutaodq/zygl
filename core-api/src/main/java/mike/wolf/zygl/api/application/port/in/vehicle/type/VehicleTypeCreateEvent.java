package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder()
public class VehicleTypeCreateEvent {
    @NotNull(message = "车辆状态聚合标识对象不能为空")
    @TargetAggregateIdentifier
    private VehicleTypeId vehicleTypeId;

    @NotNull(message = "车辆状态名称对象不能为空")
    private TypeName typeName;

    String description; // 备注

}
