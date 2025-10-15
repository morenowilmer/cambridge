package co.com.polijic.cambridge.graphql;

import co.com.polijic.cambridge.adapter.port.SalonClasePort;
import co.com.polijic.cambridge.domain.dto.SalonClaseDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class SalonClaseGraphqlController {

    private final SalonClasePort salonClasePort;

    public SalonClaseGraphqlController(SalonClasePort salonClasePort) {
        this.salonClasePort = salonClasePort;
    }

    @QueryMapping
    public List<SalonClaseDto> listarSalonesClase() {
        return salonClasePort.consultarSalonesClase();
    }

    @QueryMapping
    public SalonClaseDto buscarSalonClasePorId(@Argument Integer idSalonClase) {
        return salonClasePort.consultarSalonClase(idSalonClase);
    }

    @MutationMapping
    public SalonClaseDto guardarSalonClase(@Argument("salonClaseInput") SalonClaseDto salonClase) {
        return salonClasePort.guardarSalonClase(salonClase);
    }

    @MutationMapping
    public SalonClaseDto eliminarSalonClase(@Argument Integer idSalonClase) {
        SalonClaseDto salonClase = salonClasePort.consultarSalonClase(idSalonClase);
        if (Objects.nonNull(salonClase)) {
            salonClasePort.eliminarSalonClase(idSalonClase);
        }
        return salonClase;
    }
}
