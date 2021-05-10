package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;

import java.util.concurrent.CompletableFuture;

public interface ExistsByNameVehicleTypeUseCase {
    public CompletableFuture<Boolean> existsByName(String name);

    /*
命令
*/
    @Builder()
    @Value
    public class ExistsByNameVehicleTypeQuery {
        TypeName typeName;
    }

}
