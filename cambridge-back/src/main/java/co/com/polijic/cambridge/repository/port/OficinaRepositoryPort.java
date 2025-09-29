package co.com.polijic.cambridge.repository.port;

import co.com.polijic.cambridge.domain.dto.OficinaDto;

import java.util.List;

public interface OficinaRepositoryPort {

    List<OficinaDto> findAll();
    OficinaDto save(OficinaDto oficinaDto);
    OficinaDto findById(Integer id);
    void delete(Integer idOficna);
}
