package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.type.UpdateVehicleTypeNameUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateNameVehicleStateService implements UpdateVehicleTypeNameUseCase {
    private final CommandGateway commandGateway;
    @Override
    public void updateName(UpdateVehicleTypeNameCommand command) {
        commandGateway.send(command);

    }
}
