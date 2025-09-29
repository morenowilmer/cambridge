package co.com.polijic.cambridge.controller;

import co.com.polijic.cambridge.adapter.port.OficinaPort;
import co.com.polijic.cambridge.domain.common.GeneralResponse;
import co.com.polijic.cambridge.domain.dto.OficinaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/oficina")
public class OficinaController {

    private final OficinaPort oficinaPort;

    public OficinaController(OficinaPort oficinaPort) {
        this.oficinaPort = oficinaPort;
    }

    @ResponseBody
    @GetMapping(value = "/listar", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<OficinaDto>>> consultarOficinas() {
        List<OficinaDto> response = oficinaPort.consultarOficnas();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @PostMapping(value = "/guardar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GeneralResponse<OficinaDto>> guardarOficina(@RequestBody OficinaDto oficinaDto) {
        OficinaDto response = oficinaPort.guardarOficina(oficinaDto);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @GetMapping(value = "/consultar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<OficinaDto>> consultarOficina(@PathVariable("id") Integer id) {
        OficinaDto response = oficinaPort.consultarOficina(id);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<Boolean>> eliminarOficina(@PathVariable("id") Integer id) {
        oficinaPort.eliminarOficina(id);

        return ResponseEntity.ok(GeneralResponse.exito(true));
    }
}
