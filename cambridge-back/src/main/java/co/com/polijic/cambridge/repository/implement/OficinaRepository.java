package co.com.polijic.cambridge.repository.implement;

import co.com.polijic.cambridge.domain.dto.OficinaDto;
import co.com.polijic.cambridge.repository.BdRepository.BdOficinaRepository;
import co.com.polijic.cambridge.repository.entities.OficinaEntity;
import co.com.polijic.cambridge.repository.port.OficinaRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaRepository implements OficinaRepositoryPort {

    private final BdOficinaRepository oficinaRepository;
    private final ModelMapper modelMapper;

    public OficinaRepository(BdOficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<OficinaDto> findAll() {
        List<OficinaEntity> lista = oficinaRepository.findAll();
        return lista.stream()
                .map(o -> modelMapper.map(o, OficinaDto.class)).toList();
    }

    @Override
    public OficinaDto save(OficinaDto oficinaDto) {
        OficinaEntity oficinaEntity = modelMapper.map(oficinaDto, OficinaEntity.class);
        return modelMapper.map(oficinaRepository.save(oficinaEntity), OficinaDto.class);
    }

    @Override
    public OficinaDto findById(Integer id) {
        return modelMapper.map(oficinaRepository.findById(id), OficinaDto.class);
    }

    @Override
    public void delete(Integer idOficna) {
        oficinaRepository.deleteById(idOficna);
    }
}
