package co.com.polijic.cambridge.repository.port;

import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.ProfesorDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;

import java.util.List;

public interface PersonaRepositoryPort {

    List<PersonaDto> findAllPersonas();
    PersonaDto findPersonaById(Integer id);
    PersonaDto savePersona(PersonaDto personaDto);
    void deletePersona(Integer id);
    List<TipoDto> findAllTiposIdentificacion();
    TipoDto findTipoIdentificacionById(String codigo);
    List<TipoDto> findAllClasificacionesPersonas();
    TipoDto findClasificacionPersonaById(String codigo);
    List<TipoDto> findAllTiposProfesor();
    TipoDto findTipoProfesorByCodigo(String codigo);
    ProfesorDto findProfesorByIdPersona(Integer idPersona);
    ProfesorDto saveProfesor(ProfesorDto profesorDto);
}
