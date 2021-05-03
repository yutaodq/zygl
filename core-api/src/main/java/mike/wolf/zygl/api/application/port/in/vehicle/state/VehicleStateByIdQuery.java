package mike.wolf.zygl.api.application.port.in.vehicle.state;

import lombok.*;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;

@Builder
@Value
public class VehicleStateByIdQuery {
    VehicleStateId vehicleStateId;
}
