package co.com.polijic.cambridge.adapter.port;

import co.com.polijic.cambridge.domain.dto.AreaDto;
import co.com.polijic.cambridge.domain.dto.reportes.AreaReporte;

import java.util.List;

public interface AreaPort {

    List<AreaDto> consultarAreas();
    AreaDto guardarArea(AreaDto areaDto);
    AreaDto consultarArea(Integer idArea);
    void eliminarArea(Integer idArea);
    List<AreaReporte> consultarAreasReporte();
}
