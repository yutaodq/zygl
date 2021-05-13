package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.state.DeleteVehicleStateUseCase;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class DeleteVehicleStateService implements DeleteVehicleStateUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void deleteVehicleState(String id) {
        DeleteVehicleStateCommand command = DeleteVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(id))
                .build();
        commandGateway.send(command);

    }
}
