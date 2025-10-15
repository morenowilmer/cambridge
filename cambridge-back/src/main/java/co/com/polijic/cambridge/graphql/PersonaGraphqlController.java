package co.com.polijic.cambridge.graphql;

import co.com.polijic.cambridge.adapter.port.PersonaPort;
import co.com.polijic.cambridge.domain.dto.PersonaDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class PersonaGraphqlController {

    private final PersonaPort personaPort;

    public PersonaGraphqlController(PersonaPort personaPort) {
        this.personaPort = personaPort;
    }

    @QueryMapping
    public List<PersonaDto> listarPersonas() {
        return personaPort.consultarPersonas();
    }

    @QueryMapping
    public PersonaDto buscarPersonaPorId(@Argument Integer idPersona) {
        return personaPort.consultarPersona(idPersona);
    }

    @MutationMapping
    public PersonaDto guardarPersona(@Argument("personaInput") PersonaDto persona) {
        return personaPort.guardarPersona(persona);
    }

    @MutationMapping
    public PersonaDto eliminarPersona(@Argument Integer idPersona) {
        PersonaDto persona = personaPort.consultarPersona(idPersona);

        if (Objects.nonNull(persona)) {
            personaPort.eliminarPersona(idPersona);
        }
        return persona;
    }
}
