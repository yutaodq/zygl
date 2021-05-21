package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;

import java.util.concurrent.CompletableFuture;

public interface ExistsByPzVehicleUseCase {
    public CompletableFuture<Boolean> existsByPz(String pz);

    /*
命令
*/
    @Builder()
    @Value
    public class ExistsByPzQuery {
        String pz;
    }

}
