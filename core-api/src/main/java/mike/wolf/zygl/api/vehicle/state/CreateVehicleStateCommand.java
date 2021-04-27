package mike.wolf.zygl.api.vehicle.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import javax.validation.constraints.NotNull;

@Builder(toBuilder = true)
@Value
public class CreateVehicleStateCommand {

    @NotNull(message = "工具标识对象不能为空")
    @TargetAggregateIdentifier
    VehicleStateId vehicleStateId;

    @NotNull(message = "工具名称对象不能为空")
    StateName stateName;

    String description; // 备注

}
