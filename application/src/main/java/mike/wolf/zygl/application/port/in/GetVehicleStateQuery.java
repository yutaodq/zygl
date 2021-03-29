package mike.wolf.zygl.application.port.in;

import mike.wolf.zygl.application.model.VehicleStateDTO;

import java.util.List;
import java.util.Map;

public interface GetVehicleStateQuery {
    public Map<String, List<VehicleStateDTO>> findAll();

    }
