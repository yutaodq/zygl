package mike.wolf.zygl.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface VehicleStateRepository extends JpaRepository<VehicleStateJpaEntity, String> {

}
