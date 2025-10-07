package co.com.polijic.cambridge.repository.implement;

import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.ProfesorDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import co.com.polijic.cambridge.repository.BdRepository.*;
import co.com.polijic.cambridge.repository.entities.PersonaEntity;
import co.com.polijic.cambridge.repository.entities.ProfesorEntity;
import co.com.polijic.cambridge.repository.port.PersonaRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepository implements PersonaRepositoryPort {

    private final BdPersonaRepository bdPersonaRepository;
    private final BdClasificacionPersonaRepository clasificacionPersonaRepository;
    private final BdTipoIdentificacionRepository tipoIdentificacionRepository;
    private final BdTipoProfesorRepository tipoProfesorRepository;
    private final BdProfesorRepository profesorRepository;
    private final ModelMapper modelMapper;

    public PersonaRepository(BdPersonaRepository bdPersonaRepository,
                             BdClasificacionPersonaRepository clasificacionPersonaRepository,
                             BdTipoIdentificacionRepository tipoIdentificacionRepository,
                             BdTipoProfesorRepository tipoProfesorRepository,
                             BdProfesorRepository profesorRepository) {
        this.bdPersonaRepository = bdPersonaRepository;
        this.clasificacionPersonaRepository = clasificacionPersonaRepository;
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
        this.tipoProfesorRepository = tipoProfesorRepository;
        this.profesorRepository = profesorRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<PersonaDto> findAllPersonas() {
        return bdPersonaRepository.findAll().stream()
                .map(p -> modelMapper.map(p, PersonaDto.class)).toList();
    }

    @Override
    public PersonaDto findPersonaById(Integer id) {
        return modelMapper.map(bdPersonaRepository.findById(id), PersonaDto.class);
    }

    @Override
    public PersonaDto savePersona(PersonaDto personaDto) {
        return modelMapper.map(bdPersonaRepository.save(modelMapper.map(personaDto, PersonaEntity.class)), PersonaDto.class);
    }

    @Override
    public void deletePersona(Integer id) {
        bdPersonaRepository.deleteById(id);
    }

    @Override
    public List<TipoDto> findAllTiposIdentificacion() {
        return tipoIdentificacionRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TipoDto.class)).toList();
    }

    @Override
    public TipoDto findTipoIdentificacionById(String codigo) {
        return modelMapper.map(tipoIdentificacionRepository.findById(codigo), TipoDto.class);
    }

    @Override
    public List<TipoDto> findAllClasificacionesPersonas() {
        return clasificacionPersonaRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TipoDto.class)).toList();
    }

    @Override
    public TipoDto findClasificacionPersonaById(String codigo) {
        return modelMapper.map(clasificacionPersonaRepository.findById(codigo), TipoDto.class);
    }

    @Override
    public List<TipoDto> findAllTiposProfesor() {
        return tipoProfesorRepository.findAll().stream()
                .map(p -> modelMapper.map(p, TipoDto.class)).toList();
    }

    @Override
    public TipoDto findTipoProfesorByCodigo(String codigo) {
        return modelMapper.map(tipoProfesorRepository.findById(codigo), TipoDto.class);
    }

    @Override
    public ProfesorDto findProfesorByIdPersona(Integer idPersona) {
        Optional<ProfesorEntity> profesor = profesorRepository
                .findByIdPersona(idPersona);
        return profesor.map(profesorEntity -> modelMapper.map(profesorEntity, ProfesorDto.class))
                .orElse(null);
    }

    @Override
    public ProfesorDto saveProfesor(ProfesorDto profesorDto) {
        ProfesorEntity entity = modelMapper.map(profesorDto, ProfesorEntity.class);

        return modelMapper.map(profesorRepository.save(entity), ProfesorDto.class);
    }
}
