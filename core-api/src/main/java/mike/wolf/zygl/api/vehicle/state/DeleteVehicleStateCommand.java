package mike.wolf.zygl.api.vehicle.state;

import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

@Builder()
@Value
public class DeleteVehicleStateCommand {

    @NotNull(message = "工具标识对象不能为空")
    @TargetAggregateIdentifier
    private VehicleStateId vehicleStateId;
}
