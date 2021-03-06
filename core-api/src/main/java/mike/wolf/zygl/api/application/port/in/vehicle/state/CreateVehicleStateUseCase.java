package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface CreateVehicleStateUseCase {
    public void createVehicleState(CreateVehicleStateCommand command);

    @Builder()
    @Value
    public class CreateVehicleStateCommand {

        @NotNull(message = "状态标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleStateId vehicleStateId;

        @NotNull(message = "状态名称对象不能为空")
        StateName stateName;

        String description; // 备注

    }

}
