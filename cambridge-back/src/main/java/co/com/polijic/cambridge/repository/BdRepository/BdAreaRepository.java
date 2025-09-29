package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdAreaRepository extends JpaRepository<AreaEntity, Integer> {
}
