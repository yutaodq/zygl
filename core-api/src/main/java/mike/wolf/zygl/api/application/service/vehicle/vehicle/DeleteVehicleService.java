package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.DeleteVehicleUseCase;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class DeleteVehicleService implements DeleteVehicleUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void deleteVehicle(String id) {
        DeleteVehicleCommand command = DeleteVehicleCommand
                .builder()
                .vehicleId(VehicleId.create(id))
                .build();
        commandGateway.send(command);

    }
}
