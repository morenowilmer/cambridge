package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.TipoProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdTipoProfesorRepository extends JpaRepository<TipoProfesorEntity, String> {
}
