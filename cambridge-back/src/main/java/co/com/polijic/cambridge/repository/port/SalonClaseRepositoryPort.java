package co.com.polijic.cambridge.repository.port;

import co.com.polijic.cambridge.domain.dto.SalonClaseDto;

import java.util.List;

public interface SalonClaseRepositoryPort {

    List<SalonClaseDto> findAll();
    SalonClaseDto findById(Integer id);
    SalonClaseDto save(SalonClaseDto salonClase);
    void delete(Integer idSalonClase);
}
