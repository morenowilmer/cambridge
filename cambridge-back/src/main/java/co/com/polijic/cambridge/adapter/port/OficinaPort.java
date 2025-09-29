package co.com.polijic.cambridge.adapter.port;

import co.com.polijic.cambridge.domain.dto.OficinaDto;

import java.util.List;

public interface OficinaPort {

    List<OficinaDto> consultarOficnas();
    OficinaDto guardarOficina(OficinaDto oficinaDto);
    OficinaDto consultarOficina(Integer idOficina);
    void eliminarOficina(Integer idOficna);
}
