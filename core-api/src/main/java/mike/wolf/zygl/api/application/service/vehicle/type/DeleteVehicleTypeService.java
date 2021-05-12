package mike.wolf.zygl.api.application.service.vehicle.type;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.port.in.vehicle.type.DeleteVehicleTypeUseCase;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class DeleteVehicleTypeService implements DeleteVehicleTypeUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void deleteVehicleType(String id) {
        DeleteVehicleTypeCommand command = DeleteVehicleTypeCommand
                .builder()
                .vehicleTypeId(VehicleTypeId.create(id))
                .build();
        commandGateway.send(command);

    }
}
