package mike.wolf.zygl.adapter.persistence.repositories;

import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleStateRepository extends JpaRepository<VehicleStateJpaEntity, String> {

//    Optional<Boolean> existsByName(String name);
    boolean existsByName(String name);

    List<VehicleStateJpaEntity> findByName(String name);
}
