package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface FindByIdVehicleTypeUseCase {
    public CompletableFuture<ResponseEntity<VehicleTypeDTO>> findById(String id);

    /*
命令
 */
    @Builder()
    @Value
    public class FindByIdVehicleTypeQuery {
        VehicleTypeId vehicleTypeId;
    }


}
