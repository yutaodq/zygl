package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.UpdateVehicleUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateVehicleService  implements UpdateVehicleUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void update(UpdateVehicleCommand command) {
        commandGateway.send(command);

    }
}
