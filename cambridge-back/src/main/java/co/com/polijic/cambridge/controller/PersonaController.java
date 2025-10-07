package co.com.polijic.cambridge.controller;

import co.com.polijic.cambridge.adapter.port.PersonaPort;
import co.com.polijic.cambridge.domain.common.GeneralResponse;
import co.com.polijic.cambridge.domain.dto.PersonaDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaPort personaPort;

    public PersonaController(PersonaPort personaPort) {
        this.personaPort = personaPort;
    }

    @ResponseBody
    @GetMapping(value = "/listar", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<PersonaDto>>> consultarPersonas() {
        List<PersonaDto> response = personaPort.consultarPersonas();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @PostMapping(value = "/guardar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GeneralResponse<PersonaDto>> guardarPersona(@RequestBody PersonaDto personaDto) {
        try {
            PersonaDto response = personaPort.guardarPersona(personaDto);

            return ResponseEntity.ok(GeneralResponse.exito(response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.error(null));
        }
    }

    @ResponseBody
    @GetMapping(value = "/consultar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<PersonaDto>> consultarPersona(@PathVariable("id") Integer id) {
        PersonaDto response = personaPort.consultarPersona(id);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<Boolean>> eliminarPersona(@PathVariable("id") Integer id) {
        try {
            personaPort.eliminarPersona(id);

            return ResponseEntity.ok(GeneralResponse.exito(true));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.error(false));
        }
    }

    @ResponseBody
    @GetMapping(value = "/tipos-identificacion", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<TipoDto>>> consultarTiposIdentificacion() {
        List<TipoDto> response = personaPort.consultarTiposIdentificacion();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @GetMapping(value = "/tipos-clasificacion", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<TipoDto>>> consultarTiposClasificacion() {
        List<TipoDto> response = personaPort.consultarTiposClasificacion();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @GetMapping(value = "/tipos-profesor", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<TipoDto>>> consultarTiposProfesor() {
        List<TipoDto> response = personaPort.consultarTiposProfesores();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }
}
