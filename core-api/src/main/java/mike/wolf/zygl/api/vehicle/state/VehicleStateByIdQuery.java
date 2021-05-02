package mike.wolf.zygl.api.vehicle.state;

import lombok.*;

@Builder
@Value
public class VehicleStateByIdQuery {
    VehicleStateId vehicleStateId;
}
