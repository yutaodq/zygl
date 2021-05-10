package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FindAllVehicleTypeUseCase {
    CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAll();

    /*
命令
 */
    @Builder()
    @Getter
    public class FindAllVehicleTypeQuery {
    }

}
