package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.exception.DuplicatedNameException;
import mike.wolf.zygl.adapter.persistence.exception.NotFoundException;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.port.out.VehicleStateCommandPort;
import mike.wolf.zygl.common.PersistenceAdapter;
import org.springframework.dao.DataIntegrityViolationException;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStatePersistenceAdapter implements VehicleStateCommandPort {
    private final VehicleStateRepository vehicleStateRepository;

    @Override
    public void create(
            String identifier, String name, String description
    ) {
        VehicleStateJpaEntity entity = VehicleStateJpaEntity.builder()
                .identifier(identifier)
                .name(name)
                .description(description)
                .build();
        try {
            vehicleStateRepository.save(entity).getId();

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }


    }

    @Override
    public void delete(String id) {
        if (!findById(id).getId().isEmpty()) {
            vehicleStateRepository.deleteById(id);
        }
    }

    private VehicleStateJpaEntity findById(String id) {
        return vehicleStateRepository.findById(id)
                .orElseThrow(() -> NotFoundException.from("车辆状态为：" + id));
    }

    @Override
    public void update(String id, String description) {

         VehicleStateJpaEntity entity = findById(id);
        entity = entity.toBuilder().description(description).build();
        vehicleStateRepository.save(entity);
    }

    public void updateName(String id, String name) {

        VehicleStateJpaEntity entity = findById(id);
        entity = entity.toBuilder().description(name).build();
        
        try {
            vehicleStateRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }
    }
}
