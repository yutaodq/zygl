package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface CreateVehicleTypeUseCase {
    public void CreateVehicleType(CreateVehicleTypeCommand command);

    @Builder()
    @Value
    public class CreateVehicleTypeCommand {

        @NotNull(message = "状态标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleTypeId vehicleTypeId;

        @NotNull(message = "状态名称对象不能为空")
        TypeName typeName;

        String description; // 备注

    }

}
