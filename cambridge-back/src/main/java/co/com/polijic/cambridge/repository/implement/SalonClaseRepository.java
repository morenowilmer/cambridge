package co.com.polijic.cambridge.repository.implement;

import co.com.polijic.cambridge.domain.dto.SalonClaseDto;
import co.com.polijic.cambridge.repository.BdRepository.BdSalonClaseRepository;
import co.com.polijic.cambridge.repository.entities.SalonClaseEntity;
import co.com.polijic.cambridge.repository.port.SalonClaseRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonClaseRepository implements SalonClaseRepositoryPort {

    private final BdSalonClaseRepository bdSalonClaseRepository;
    private final ModelMapper modelMapper;

    public SalonClaseRepository(BdSalonClaseRepository bdSalonClaseRepository) {
        this.bdSalonClaseRepository = bdSalonClaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<SalonClaseDto> findAll() {
        return bdSalonClaseRepository.findAll().stream()
                .map(c -> modelMapper.map(c, SalonClaseDto.class)).toList();
    }

    @Override
    public SalonClaseDto findById(Integer id) {
        return modelMapper.map(bdSalonClaseRepository.findById(id), SalonClaseDto.class);
    }

    @Override
    public SalonClaseDto save(SalonClaseDto salonClase) {
        SalonClaseEntity salonClaseEntity = modelMapper.map(salonClase, SalonClaseEntity.class);
        return modelMapper.map(bdSalonClaseRepository.save(salonClaseEntity), SalonClaseDto.class);
    }

    @Override
    public void delete(Integer idSalonClase) {
        bdSalonClaseRepository.deleteById(idSalonClase);
    }
}
