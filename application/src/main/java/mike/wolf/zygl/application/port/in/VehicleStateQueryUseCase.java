package mike.wolf.zygl.application.port.in;

import mike.wolf.zygl.api.application.model.VehicleStateDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleStateQueryUseCase {
    public List<VehicleStateDTO> findAll();

    Optional<VehicleStateDTO> findById(String id);

    boolean existsByName(String name);

    List<VehicleStateDTO> findByName(String name);
}