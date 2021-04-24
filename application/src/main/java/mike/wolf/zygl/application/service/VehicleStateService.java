package mike.wolf.zygl.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateDeleteUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateUpdateUseCase;
import mike.wolf.zygl.application.port.out.VehicleStateCommandPort;
import mike.wolf.zygl.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class VehicleStateService  implements
        VehicleStateCreateUseCase,
        VehicleStateDeleteUseCase,
        VehicleStateUpdateUseCase {

    private final VehicleStateCommandPort vehicleStateCommandPort;

    @Override
    public void create(CreateVehicleStateCommand command) {
        vehicleStateCommandPort.create(
                command.getVehicleStateId().getValue(),
                command.getName(),
                command.getDescription()
        );
    }

    @Override
    public void delete(DeleteVehicleStateCommand command) {
        vehicleStateCommandPort.delete(command.getId());
    }

    @Override
    public void update(UpdateVehicleStateCommand command) {
        vehicleStateCommandPort.update(
                command.getId(),
                command.getDescription()
        );

    }
}
