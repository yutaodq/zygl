package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.state.CreateVehicleStateUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class CretateVehicleStateService implements CreateVehicleStateUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void createVehicleState(CreateVehicleStateCommand command) {
        commandGateway.sendAndWait(command);
    }
}
