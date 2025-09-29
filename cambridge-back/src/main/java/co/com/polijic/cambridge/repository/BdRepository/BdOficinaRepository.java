package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.OficinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdOficinaRepository extends JpaRepository<OficinaEntity, Integer> {
}
