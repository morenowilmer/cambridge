package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.SalonClasePort;
import co.com.polijic.cambridge.domain.dto.SalonClaseDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.domain.dto.reportes.SalonClaseReporte;
import co.com.polijic.cambridge.domain.enums.EnumEstadoSalonClase;
import co.com.polijic.cambridge.repository.port.SalonClaseRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SalonClaseAdapter implements SalonClasePort {

    private final SalonClaseRepositoryPort salonClaseRepositoryPort;

    public SalonClaseAdapter(SalonClaseRepositoryPort salonClaseRepositoryPort) {
        this.salonClaseRepositoryPort = salonClaseRepositoryPort;
    }

    @Override
    public List<SalonClaseDto> consultarSalonesClase() {
        return salonClaseRepositoryPort.findAll().stream()
                .map(s -> {
                    s.setLabelEstado(EnumEstadoSalonClase.valueOf(s.getEstado()).getTitulo());
                    return s;
                }).toList();
    }

    @Override
    public SalonClaseDto guardarSalonClase(SalonClaseDto salonClase) {
        return salonClaseRepositoryPort.save(salonClase);
    }

    @Override
    public SalonClaseDto consultarSalonClase(Integer idSalonClase) {
        SalonClaseDto salonClase = salonClaseRepositoryPort.findById(idSalonClase);

        if(Objects.nonNull(salonClase))
            salonClase.setLabelEstado(EnumEstadoSalonClase.valueOf(salonClase.getEstado()).getTitulo());

        return salonClase;
    }

    @Override
    public void eliminarSalonClase(Integer idSalonClase) {
        salonClaseRepositoryPort.delete(idSalonClase);
    }

    @Override
    public List<TipoDto> consultarEstadosSalonClase() {
        return Arrays.stream(EnumEstadoSalonClase.values())
                .map(e -> TipoDto.builder()
                        .codigo(e.getCodigo())
                        .nombre(e.getTitulo()).build()).toList();
    }

    @Override
    public List<SalonClaseReporte> consultarSalonesClaseReporte() {
        return this.consultarSalonesClase().stream()
                .map(s -> SalonClaseReporte.builder()
                        .id(s.getId())
                        .bloque(s.getBloque())
                        .numeroSalon(s.getNumeroSalon())
                        .capacidad(s.getCapacidad())
                        .grado(s.getGrado())
                        .estado(s.getLabelEstado()).build()).toList();
    }
}
