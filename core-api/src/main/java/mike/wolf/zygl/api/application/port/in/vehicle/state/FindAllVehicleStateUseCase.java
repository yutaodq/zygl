package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Getter;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FindAllVehicleStateUseCase {
    CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAll();

    /*
命令
 */
    @Builder()
    @Getter
    public class FindAllVehicleStateQuery {
    }

}
