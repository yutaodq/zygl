package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.CreateVehicleUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class CretateVehicleService implements CreateVehicleUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void createVehicle(CreateVehicleCommand command) {
        commandGateway.sendAndWait(command);
    }
}
