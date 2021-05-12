package mike.wolf.zygl.api.application.service.vehicle.type;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.type.UpdateVehicleTypeUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class UpdateVehicleTypeService  implements UpdateVehicleTypeUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void update(UpdateVehicleTypeCommand command) {
        commandGateway.send(command);

    }
}
