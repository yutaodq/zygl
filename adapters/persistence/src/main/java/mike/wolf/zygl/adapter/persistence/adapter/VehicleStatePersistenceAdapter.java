package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.port.out.VehicleStateCommPort;
import mike.wolf.zygl.common.PersistenceAdapter;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStatePersistenceAdapter implements VehicleStateCommPort {
    private final VehicleStateRepository vehicleStateRepository;

    @Override
    public void create(String vehicleStateId, String name, String description) {
        VehicleStateJpaEntity entity = new VehicleStateJpaEntity()
    }
}
