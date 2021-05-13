package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.state.UpdateVehicleStateUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.UpdateVehicleTypeUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateStateTypeService implements UpdateVehicleStateUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void update(UpdateVehicleStateCommand command) {
        commandGateway.send(command);

    }
}
