package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

import java.util.concurrent.CompletableFuture;

public interface ExistsByNbpzVehicleUseCase {
    public CompletableFuture<Boolean> existsByNbpz(String nbpz);

    /*
命令
*/
    @Builder()
    @Value
    public class ExistsByNbpzQuery {
        String nbpz;
    }

}
