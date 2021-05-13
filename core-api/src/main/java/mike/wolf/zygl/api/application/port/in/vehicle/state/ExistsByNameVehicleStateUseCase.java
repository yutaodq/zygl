package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;

import java.util.concurrent.CompletableFuture;

public interface ExistsByNameVehicleStateUseCase {
    public CompletableFuture<Boolean> existsByName(String name);

    /*
命令
*/
    @Builder()
    @Value
    public class ExistsByNameVehicleStateQuery {
        StateName stateName;
    }

}
