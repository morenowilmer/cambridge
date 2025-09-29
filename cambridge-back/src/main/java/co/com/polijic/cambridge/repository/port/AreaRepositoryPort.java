package co.com.polijic.cambridge.repository.port;

import co.com.polijic.cambridge.domain.dto.AreaDto;

import java.util.List;

public interface AreaRepositoryPort {

    List<AreaDto> findAll();
    AreaDto save(AreaDto areaDto);
    AreaDto findById(Integer id);
    void delete(Integer idArea);
}
