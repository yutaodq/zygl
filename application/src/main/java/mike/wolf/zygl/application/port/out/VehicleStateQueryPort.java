package mike.wolf.zygl.application.port.out;

import mike.wolf.zygl.api.application.model.VehicleStateDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleStateQueryPort {
    List<VehicleStateDTO> findAllVehicleStates();

    Optional<VehicleStateDTO> findById(String id);

    boolean existsByName(String name);

    List<VehicleStateDTO> findByName(String name);
}
