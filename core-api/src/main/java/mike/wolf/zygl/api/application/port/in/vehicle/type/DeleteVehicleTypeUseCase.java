package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

public interface DeleteVehicleTypeUseCase {
    public void DeleteVehicleType(String id);

    /*
命令
 */
    @Builder()
    @Value
    public class DeleteVehicleTypeCommand {
        @NotNull(message = "工具标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleTypeId vehicleTypeId;
    }

}
