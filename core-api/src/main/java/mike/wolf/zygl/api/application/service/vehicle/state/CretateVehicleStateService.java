package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.type.CreateVehicleTypeUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class CretateVehicleStateService implements CreateVehicleTypeUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void createVehicleType(CreateVehicleTypeCommand command) {
        commandGateway.sendAndWait(command);
    }
}
