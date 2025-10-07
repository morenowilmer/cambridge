package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.OficinaPort;
import co.com.polijic.cambridge.adapter.port.PersonaPort;
import co.com.polijic.cambridge.adapter.port.SalonClasePort;
import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.ProfesorDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.repository.implement.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonaAdapter implements PersonaPort {

    private final PersonaRepository personaRepository;
    private final SalonClasePort salonClasePort;
    private final OficinaPort oficinaPort;

    public PersonaAdapter(PersonaRepository personaRepository,
                          SalonClasePort salonClasePort,
                          OficinaPort oficinaPort) {
        this.personaRepository = personaRepository;
        this.salonClasePort = salonClasePort;
        this.oficinaPort = oficinaPort;
    }

    @Override
    public List<PersonaDto> consultarPersonas() {
        return personaRepository.findAllPersonas().stream()
                .map(p -> this.cargarDatosPersona(p.getId())).toList();
    }

    @Override
    public PersonaDto consultarPersona(Integer id) {
        return this.cargarDatosPersona(id);
    }

    @Override
    public PersonaDto guardarPersona(PersonaDto personaDto) {
        PersonaDto persona = personaRepository.savePersona(personaDto);

        if (persona.getClasificacion().equals("PROFES")) {
            personaRepository.saveProfesor(personaDto.getProfesor());
        }

        return this.cargarDatosPersona(persona.getId());
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

    @Override
    public List<TipoDto> consultarTiposProfesores() {
        return personaRepository.findAllTiposProfesor();
    }

    private PersonaDto cargarDatosPersona(Integer idPersona) {
        PersonaDto persona = personaRepository.findPersonaById(idPersona);

        if (Objects.isNull(persona)) return null;

        TipoDto tipoIdentificacion = personaRepository.findTipoIdentificacionById(persona.getTipoIdentificacion());
        TipoDto tipoClasificacion = personaRepository.findClasificacionPersonaById(persona.getClasificacion());
        oficinaPort.consultarOficina(persona.getIdOficina());

        persona.setTipoIdentificacionObjeto(tipoIdentificacion);
        persona.setTipoClasificacionObjeto(tipoClasificacion);

        if (persona.getClasificacion().equals("PROFES")) {
            ProfesorDto profesor = personaRepository.findProfesorByIdPersona(persona.getId());
            profesor.setSalonClaseObjeto(salonClasePort.consultarSalonClase(profesor.getIdSalon()));
            profesor.setTipoProfesorObjeto(personaRepository.findTipoProfesorByCodigo(profesor.getTipoProfesor()));
            persona.setProfesor(profesor);
        }

        return persona;
    }
}
