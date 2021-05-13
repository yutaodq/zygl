package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.state.UpdateVehicleStateNameUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateNameVehicleStateService implements UpdateVehicleStateNameUseCase {
    private final CommandGateway commandGateway;
    @Override
    public void updateName(UpdateVehicleStateNameCommand command) {
        commandGateway.send(command);

    }
}
