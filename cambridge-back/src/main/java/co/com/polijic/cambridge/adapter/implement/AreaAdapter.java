package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.AreaPort;
import co.com.polijic.cambridge.domain.dto.AreaDto;
import co.com.polijic.cambridge.repository.port.AreaRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AreaAdapter implements AreaPort {

    private final AreaRepositoryPort areaRepositoryPort;

    public AreaAdapter(AreaRepositoryPort areaRepositoryPort) {
        this.areaRepositoryPort = areaRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDto> consultarAreas() {
        return areaRepositoryPort.findAll();
    }

    @Override
    public AreaDto guardarArea(AreaDto areaDto) {
        if (Objects.isNull(areaDto.getFechaCreacion()))
            areaDto.setFechaCreacion(LocalDate.now());
        return areaRepositoryPort.save(areaDto);
    }

    @Override
    public AreaDto consultarArea(Integer idArea) {
        return areaRepositoryPort.findById(idArea);
    }

    @Override
    public void eliminarArea(Integer idArea) {
        areaRepositoryPort.delete(idArea);
    }
}
