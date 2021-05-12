package mike.wolf.zygl.api.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.type.CreateVehicleTypeUseCase;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class CretateVehicleTypeService implements CreateVehicleTypeUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void createVehicleType(CreateVehicleTypeCommand command) {
        commandGateway.sendAndWait(command);
    }
}
