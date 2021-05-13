package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

public interface FindByIdVehicleStateUseCase {
    public CompletableFuture<ResponseEntity<VehicleStateDTO>> findById(String id);

    /*
命令
 */
    @Builder()
    @Value
    public class FindByIdVehicleStateQuery {
        @NotNull(message = "车辆状态标识对象不能为空")
        @TargetAggregateIdentifier
        VehicleStateId vehicleStateId;
    }


}
