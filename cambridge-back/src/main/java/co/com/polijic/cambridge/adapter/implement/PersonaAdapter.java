package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.PersonaPort;
import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.repository.implement.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonaAdapter implements PersonaPort {

    private final PersonaRepository personaRepository;

    public PersonaAdapter(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<PersonaDto> consultarPersonas() {
        return personaRepository.findAllPersonas().stream()
                .map(p -> {
                    TipoDto tipoIdentificacion = personaRepository.findTipoIdentificacionById(p.getTipoIdentificacion());
                    TipoDto tipoClasificacion = personaRepository.findClasificacionPersonaById(p.getClasificacion());
                    p.setTipoIdentificacionObjeto(tipoIdentificacion);
                    p.setTipoClasificacionObjeto(tipoClasificacion);
                    return p;
                }).toList();
    }

    @Override
    public PersonaDto consultarPersona(Integer id) {
        PersonaDto persona = personaRepository.findPersonaById(id);

        if(Objects.nonNull(persona)) {
            TipoDto tipoIdentificacion = personaRepository.findTipoIdentificacionById(persona.getTipoIdentificacion());
            TipoDto tipoClasificacion = personaRepository.findClasificacionPersonaById(persona.getClasificacion());
            persona.setTipoIdentificacionObjeto(tipoIdentificacion);
            persona.setTipoClasificacionObjeto(tipoClasificacion);
            return persona;
        }

        return null;
    }

    @Override
    public PersonaDto guardarPersona(PersonaDto personaDto) {
        return personaRepository.savePersona(personaDto);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepository.deletePersona(id);
    }

    @Override
    public List<TipoDto> consultarTiposIdentificacion() {
        return personaRepository.findAllTiposIdentificacion();
    }

    @Override
    public List<TipoDto> consultarTiposClasificacion() {
        return personaRepository.findAllClasificacionesPersonas();
    }
}
