package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.OficinaPort;
import co.com.polijic.cambridge.domain.dto.OficinaDto;
import co.com.polijic.cambridge.domain.dto.reportes.OficinaReporte;
import co.com.polijic.cambridge.repository.port.AreaRepositoryPort;
import co.com.polijic.cambridge.repository.port.OficinaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaAdapter implements OficinaPort {

    private final OficinaRepositoryPort oficinaRepositoryPort;
    private final AreaRepositoryPort areaRepositoryPort;

    public OficinaAdapter(OficinaRepositoryPort oficinaRepositoryPort,
                          AreaRepositoryPort areaRepositoryPort) {
        this.oficinaRepositoryPort = oficinaRepositoryPort;
        this.areaRepositoryPort = areaRepositoryPort;
    }

    @Override
    public List<OficinaDto> consultarOficnas() {
        return oficinaRepositoryPort.findAll().stream()
                .map(o -> {
                    o.setArea(areaRepositoryPort.findById(o.getIdArea()));
                    return o;
                }).toList();
    }

    @Override
    public OficinaDto guardarOficina(OficinaDto oficinaDto) {
        return oficinaRepositoryPort.save(oficinaDto);
    }

    @Override
    public OficinaDto consultarOficina(Integer idOficina) {
        return oficinaRepositoryPort.findById(idOficina);
    }

    @Override
    public void eliminarOficina(Integer idOficna) {
        oficinaRepositoryPort.delete(idOficna);
    }

    @Override
    public List<OficinaReporte> consultarOficnasReporte() {
        return this.consultarOficnas().stream()
                .map(o -> OficinaReporte.builder()
                        .idOficina(o.getId())
                        .nombre(o.getNombre())
                        .descripcion(o.getDescripcion())
                        .nombreArea(o.getArea().getNombre())
                        .build())
                .toList();
    }
}
