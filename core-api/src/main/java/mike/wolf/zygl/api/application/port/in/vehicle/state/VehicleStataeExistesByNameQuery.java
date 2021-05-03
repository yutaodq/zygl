package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;

@Builder
@Value
public class VehicleStataeExistesByNameQuery {
   StateName stateName;
}
