package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FindAllVehicleUseCase {
    CompletableFuture<ResponseEntity<List<VehicleDTO>>> findAll();

    /*
命令
 */
    @Builder()
    @Getter
    public class FindAllQuery {
    }

}
