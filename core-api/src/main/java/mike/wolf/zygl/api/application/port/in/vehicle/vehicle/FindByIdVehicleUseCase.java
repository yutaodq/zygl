package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

public interface FindByIdVehicleUseCase {
    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(String id);

    /*
命令
 */
    @Builder()
    @Value
    public class FindByIdVehicleQuery {
        @NotNull(message = "车辆状态标识对象不能为�?")
        @TargetAggregateIdentifier
        VehicleId vehicleId;
    }


}
