package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.SalonClaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdSalonClaseRepository extends JpaRepository<SalonClaseEntity, Integer> {
}
