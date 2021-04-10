package mike.wolf.zygl.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.VehicleStateQueryUseCase;
import mike.wolf.zygl.application.port.out.VehicleStateQueryPort;
import mike.wolf.zygl.common.UseCase;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class GetVehicleStateService implements VehicleStateQueryUseCase {
    private final VehicleStateQueryPort vehicleStateQueryPort;

    @Override
    public List<VehicleStateDTO> findAll() {
        return this.findAll(true);
    }

    private List<VehicleStateDTO> findAll(boolean removeUnavailableProducts) {
        List<VehicleStateDTO> vehicleStates = vehicleStateQueryPort.findAllVehicleStates();
        return vehicleStates;
    }

    @Override
    public Optional<VehicleStateDTO> findById(String id) {
        return vehicleStateQueryPort.findById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return vehicleStateQueryPort.existsByName(name);
    }

    @Override
    public List<VehicleStateDTO> findByName(String name) {
        return vehicleStateQueryPort.findByName(name);
    }

}

