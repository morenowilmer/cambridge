package co.com.polijic.cambridge.repository.implement;

import co.com.polijic.cambridge.domain.dto.AreaDto;
import co.com.polijic.cambridge.repository.BdRepository.BdAreaRepository;
import co.com.polijic.cambridge.repository.entities.AreaEntity;
import co.com.polijic.cambridge.repository.port.AreaRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaRepository implements AreaRepositoryPort {

    private final BdAreaRepository bdAreaRepository;
    private final ModelMapper modelMapper;

    public AreaRepository(BdAreaRepository bdAreaRepository) {
        this.bdAreaRepository = bdAreaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<AreaDto> findAll() {
        List<AreaEntity> lista = bdAreaRepository.findAll();
        return lista.stream()
                .map(a -> modelMapper.map(a, AreaDto.class)).toList();
    }

    @Override
    public AreaDto save(AreaDto areaDto) {
        AreaEntity areaEntity = modelMapper.map(areaDto, AreaEntity.class);
        return modelMapper.map(bdAreaRepository.save(areaEntity), AreaDto.class);
    }

    @Override
    public AreaDto findById(Integer id) {
        return modelMapper.map(bdAreaRepository.findById(id), AreaDto.class);
    }

    @Override
    public void delete(Integer idArea) {
        bdAreaRepository.deleteById(idArea);
    }
}
