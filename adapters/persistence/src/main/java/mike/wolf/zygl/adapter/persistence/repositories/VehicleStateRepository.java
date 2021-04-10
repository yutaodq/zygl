package mike.wolf.zygl.adapter.persistence.repositories;

import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleStateRepository extends JpaRepository<VehicleStateJpaEntity, String> {

    boolean existsByName(String name);

    List<VehicleStateJpaEntity> findByName(String name);
}
