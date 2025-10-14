package co.com.polijic.cambridge.adapter.port;

import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.domain.dto.reportes.PersonaReporte;

import java.util.List;

public interface PersonaPort {

    List<PersonaDto> consultarPersonas();
    PersonaDto consultarPersona(Integer id);
    PersonaDto guardarPersona(PersonaDto personaDto);
    void eliminarPersona(Integer id);
    List<TipoDto> consultarTiposIdentificacion();
    List<TipoDto> consultarTiposClasificacion();
    List<TipoDto> consultarTiposProfesores();
    List<PersonaReporte> consultarReportePersonas();
}
