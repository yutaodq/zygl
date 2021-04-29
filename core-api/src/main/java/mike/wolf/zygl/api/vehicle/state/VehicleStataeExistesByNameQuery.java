package mike.wolf.zygl.api.vehicle.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class VehicleStataeExistesByNameQuery {
    private final StateName stateName;
}
