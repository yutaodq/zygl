package mike.wolf.zygl.api.vehicle.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
public class VehicleStateByIdQuery {
    private final VehicleStateId vehicleStateId;
}
