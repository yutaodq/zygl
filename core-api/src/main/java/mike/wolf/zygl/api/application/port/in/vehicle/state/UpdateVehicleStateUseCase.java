package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface UpdateVehicleStateUseCase {
    public void update(UpdateVehicleStateCommand command);

    /*
命令
 */
    @Builder()
    @Value
    public class UpdateVehicleStateCommand {

        @NotNull(message = "车辆状态标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleStateId vehicleStateId;

        String description; // 备注

    }

}
