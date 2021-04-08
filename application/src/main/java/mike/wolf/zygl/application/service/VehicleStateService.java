package mike.wolf.zygl.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.out.VehicleStateCommPort;
import mike.wolf.zygl.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class VehicleStateService  implements VehicleStateCreateUseCase {
    private final VehicleStateCommPort vehicleStateCommPort;
    @Override
    public void create(CreateVehicleStateCommand command) {
        vehicleStateCommPort.create(
                command.getVehicleStateId().getValue(),
                command.getName(),
                command.getDescription()
        );
    }
}
