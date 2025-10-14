package co.com.polijic.cambridge.adapter.port;

import co.com.polijic.cambridge.domain.dto.SalonClaseDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.domain.dto.reportes.SalonClaseReporte;

import java.util.List;

public interface SalonClasePort {

    List<SalonClaseDto> consultarSalonesClase();
    SalonClaseDto guardarSalonClase(SalonClaseDto salonClase);
    SalonClaseDto consultarSalonClase(Integer idSalonClase);
    void eliminarSalonClase(Integer idSalonClase);
    List<TipoDto> consultarEstadosSalonClase();
    List<SalonClaseReporte> consultarSalonesClaseReporte();
}
