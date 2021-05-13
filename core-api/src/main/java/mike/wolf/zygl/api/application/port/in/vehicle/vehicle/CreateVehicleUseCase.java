package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface CreateVehicleUseCase {
    public void createVehicle(CreateVehicleCommand command);

    @Builder()
    @Value
    public class CreateVehicleCommand {

        @NotNull(message = "状态标识对象不能为�?")
        @TargetAggregateIdentifier
        VehicleId vehicleId;

        @NotNull(message = "状态名称对象不能为�?")
        TypeName typeName;

        String description; // 备注

    }

}
