package mike.wolf.zygl.adapter.persistence.repositories;

import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStateRepository extends JpaRepository<VehicleStateJpaEntity, String> {

}
