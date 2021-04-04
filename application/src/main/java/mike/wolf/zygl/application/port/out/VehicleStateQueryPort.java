package mike.wolf.zygl.application.port.out;

import mike.wolf.zygl.application.model.VehicleStateDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleStateQueryPort extends ManagementTransaction{
    List<VehicleStateDTO> findAllVehicleStates();

    Optional<VehicleStateDTO> findById(String id);
}
