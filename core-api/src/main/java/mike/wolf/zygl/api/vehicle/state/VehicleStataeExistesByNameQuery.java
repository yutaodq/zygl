package mike.wolf.zygl.api.vehicle.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Value
public class VehicleStataeExistesByNameQuery {
    StateName stateName;
}
