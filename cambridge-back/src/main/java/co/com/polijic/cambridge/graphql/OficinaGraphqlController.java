package co.com.polijic.cambridge.graphql;

import co.com.polijic.cambridge.adapter.port.OficinaPort;
import co.com.polijic.cambridge.domain.dto.OficinaDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class OficinaGraphqlController {

    private final OficinaPort oficinaPort;

    public OficinaGraphqlController(OficinaPort oficinaPort) {
        this.oficinaPort = oficinaPort;
    }

    @QueryMapping
    public List<OficinaDto> listarOficinas() {
        return oficinaPort.consultarOficnas();
    }

    @QueryMapping
    public OficinaDto buscarOficinaPorId(@Argument Integer id) {
        return oficinaPort.consultarOficina(id);
    }

    @MutationMapping
    public OficinaDto guardarOficina(@Argument("oficinaInput") OficinaDto oficina) {
        return oficinaPort.guardarOficina(oficina);
    }

    @MutationMapping
    public OficinaDto eliminarOficina(@Argument Integer id) {
        OficinaDto oficina = oficinaPort.consultarOficina(id);
        if (Objects.nonNull(oficina)) {
            oficinaPort.eliminarOficina(id);
        }
        return oficina;
    }
}
