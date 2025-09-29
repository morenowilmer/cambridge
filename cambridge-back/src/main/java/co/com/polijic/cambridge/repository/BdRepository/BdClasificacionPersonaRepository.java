package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.ClasificacionPersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdClasificacionPersonaRepository extends JpaRepository<ClasificacionPersonaEntity, String> {
}
