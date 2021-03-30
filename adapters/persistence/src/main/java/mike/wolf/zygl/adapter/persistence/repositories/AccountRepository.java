package mike.wolf.zygl.adapter.persistence.repositories;

import mike.wolf.zygl.adapter.persistence.entities.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
