package mike.wolf.zygl.application.port.in;

import mike.wolf.zygl.application.model.VehicleStateDTO;

import java.util.List;
import java.util.Map;

public interface GetVehicleStateUseCase {
    public List<VehicleStateDTO> findAll();

    }
