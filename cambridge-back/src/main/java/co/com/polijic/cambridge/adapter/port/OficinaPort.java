package co.com.polijic.cambridge.adapter.port;

import co.com.polijic.cambridge.domain.dto.OficinaDto;
import co.com.polijic.cambridge.domain.dto.reportes.OficinaReporte;

import java.util.List;

public interface OficinaPort {

    List<OficinaDto> consultarOficnas();
    OficinaDto guardarOficina(OficinaDto oficinaDto);
    OficinaDto consultarOficina(Integer idOficina);
    void eliminarOficina(Integer idOficna);
    List<OficinaReporte> consultarOficnasReporte();
}
