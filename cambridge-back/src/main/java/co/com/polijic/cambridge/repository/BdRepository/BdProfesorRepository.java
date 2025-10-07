package co.com.polijic.cambridge.repository.BdRepository;

import co.com.polijic.cambridge.repository.entities.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BdProfesorRepository extends JpaRepository<ProfesorEntity, Integer> {

    Optional<ProfesorEntity> findByIdPersona(Integer idPersona);
}
