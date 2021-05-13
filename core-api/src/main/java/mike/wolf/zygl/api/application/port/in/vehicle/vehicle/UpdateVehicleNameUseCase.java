package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface UpdateVehicleNameUseCase {
    public void updateName(UpdateVehicleNameCommand command);

    /*
命令
 */
    @Builder()
    @Value
    public class UpdateVehicleNameCommand {
        @NotNull(message = "车辆类型标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleId vehicleId;

        TypeName typeName;
    }

}
