package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.port.out.VehicleStateCommandPort;
import mike.wolf.zygl.common.PersistenceAdapter;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStatePersistenceAdapter implements VehicleStateCommandPort {
    private final VehicleStateRepository vehicleStateRepository;

    @Override
    public void create(
           String id, String identifier, String name, String description
    ) {
        VehicleStateJpaEntity entity = new VehicleStateJpaEntity(
                id, identifier, name, description);

        vehicleStateRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        vehicleStateRepository.deleteById(id);
    }

    @Override
    public void update(String id, String description) {
                Optional<VehicleStateJpaEntity> entity = vehicleStateRepository.findById(id);

//        VehicleStateJpaEntity entity = new VehicleStateJpaEntity(
//                id, description);
        vehicleStateRepository.save(entity.);
    }
}
