package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.UpdateVehicleNameUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateNameVehicleService implements UpdateVehicleNameUseCase {
    private final CommandGateway commandGateway;
    @Override
    public void updateName(UpdateVehicleNameCommand command) {
        commandGateway.send(command);

    }
}
