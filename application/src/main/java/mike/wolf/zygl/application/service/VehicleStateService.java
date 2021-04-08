package mike.wolf.zygl.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.port.in.VehicleStateCommUseCase;
import mike.wolf.zygl.application.port.out.VehicleStateCommPort;
import mike.wolf.zygl.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class VehicleStateService  implements VehicleStateCommUseCase {
    private final VehicleStateCommPort vehicleStateCommPort;
    @Override
    public void save() {

    }
}
