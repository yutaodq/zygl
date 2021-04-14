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
           String id, String identifier, String name, String description
    ) {
        VehicleStateJpaEntity entity = new VehicleStateJpaEntity(
                id, identifier, name, description);
        try {
            vehicleStateRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }


    }

    @Override
    public void delete(String id) {
        findById(id);
        vehicleStateRepository.deleteById(id);
    }

private VehicleStateJpaEntity findById(String id) {
        return vehicleStateRepository.findById(id)
                .orElseThrow(() -> NotFoundException.from("车辆状态为："+ id));

}
    @Override
    public void update(String id, String description) {
//        vehicleStateRepository.findByUsername(username).ifPresent(user -> {
//            throw new IllegalArgumentException("User with that name already exists!");
//        });
//        final Order order = useCase.execute(id)
//                .orElseThrow(() -> OrderNotFoundException.from(id));

        VehicleStateJpaEntity entity = findById(id);

//        vehicleStateRepository.findById(id).ifPresent(vehicleState -> {
//            entity = vehicleState;
//        }).orElseThrow(() -> NotFoundException.from(id));;

        entity.setDescription(description);
//        VehicleStateJpaEntity entity = new VehicleStateJpaEntity(
//                id, description);
        vehicleStateRepository.save(entity);
    }
}
