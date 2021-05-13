package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Value
@Builder()
public class VehicleDeleteEvent {
    @NotNull(message = "车辆状态聚合标识对象不能为�?")
    @TargetAggregateIdentifier
    private VehicleId vehicleId;

}
