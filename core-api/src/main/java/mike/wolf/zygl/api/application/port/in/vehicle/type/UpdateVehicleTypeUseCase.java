package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface UpdateVehicleTypeUseCase {
    public void update(UpdateVehicleTypeCommand command);

    /*
命令
 */
    @Builder()
    @Value
    public class UpdateVehicleTypeCommand {
        @NotNull(message = "车辆类型标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleTypeId vehicleTypeId;
        String description; // 备注
    }

}
