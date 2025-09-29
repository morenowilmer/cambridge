package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.OficinaPort;
import co.com.polijic.cambridge.domain.dto.OficinaDto;
import co.com.polijic.cambridge.repository.port.OficinaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaAdapter implements OficinaPort {

    private final OficinaRepositoryPort oficinaRepositoryPort;

    public OficinaAdapter(OficinaRepositoryPort oficinaRepositoryPort) {
        this.oficinaRepositoryPort = oficinaRepositoryPort;
    }

    @Override
    public List<OficinaDto> consultarOficnas() {
        return oficinaRepositoryPort.findAll();
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
}
