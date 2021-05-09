package mike.wolf.zygl.api.application.port.in.vehicle.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FindAllVehicleTypeUseCase {
    CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAll();
    @Builder()
    @Getter
    public class FindAllVehicleTypeQuery {
    }

}
