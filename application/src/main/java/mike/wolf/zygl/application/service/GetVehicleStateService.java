package mike.wolf.zygl.application.service;

import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.GetVehicleStateQuery;
import mike.wolf.zygl.application.port.out.VehicleStateRepositoryPort;

import java.util.List;
import java.util.Map;

public class GetVehicleStateService implements GetVehicleStateQuery {
    private VehicleStateRepositoryPort vehicleStateRepositoryPort;

    public GetVehicleStateService(VehicleStateRepositoryPort vehicleStateRepositoryPort) {
        this.vehicleStateRepositoryPort = vehicleStateRepositoryPort;
    }

    @Override
    public Map<String, List<VehicleStateDTO>> findAll() {
        return null;
    }
}
