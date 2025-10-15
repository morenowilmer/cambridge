package co.com.polijic.cambridge.graphql;

import co.com.polijic.cambridge.adapter.port.AreaPort;
import co.com.polijic.cambridge.domain.dto.AreaDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class AreaGraphQLController {

    private final AreaPort areaPort;

    public AreaGraphQLController(AreaPort areaPort) {
        this.areaPort = areaPort;
    }

    @QueryMapping
    public List<AreaDto> listarAreas() {
        return areaPort.consultarAreas();
    }

    @QueryMapping
    public AreaDto buscarAreaPorId(@Argument Integer id) {
        return areaPort.consultarArea(id);
    }

    @MutationMapping
    public AreaDto crearArea(@Argument("areaInput") AreaDto area) {
        return areaPort.guardarArea(area);
    }

    @MutationMapping
    public AreaDto actualizarArea(@Argument("areaInput") AreaDto area) {
        return areaPort.guardarArea(area);
    }

    @MutationMapping
    public AreaDto eliminarArea(@Argument Integer id) {
        AreaDto area = areaPort.consultarArea(id);
        if (Objects.nonNull(area)) {
            areaPort.eliminarArea(id);
        }
        return area;
    }
}
