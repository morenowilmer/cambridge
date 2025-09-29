package co.com.polijic.cambridge.controller;

import co.com.polijic.cambridge.adapter.port.AreaPort;
import co.com.polijic.cambridge.domain.common.GeneralResponse;
import co.com.polijic.cambridge.domain.dto.AreaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/area")
public class AreaController {

    private final AreaPort areaPort;

    public AreaController(AreaPort areaPort) {
        this.areaPort = areaPort;
    }

    @ResponseBody
    @GetMapping(value = "/listar", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<AreaDto>>> consultarAreas() {
        List<AreaDto> response = areaPort.consultarAreas();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @PostMapping(value = "/guardar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GeneralResponse<AreaDto>> guardarArea(@RequestBody AreaDto areaDto) {
        AreaDto response = areaPort.guardarArea(areaDto);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @GetMapping(value = "/consultar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<AreaDto>> consultarArea(@PathVariable("id") Integer id) {
        AreaDto response = areaPort.consultarArea(id);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<Boolean>> eliminarArea(@PathVariable("id") Integer id) {
        areaPort.eliminarArea(id);

        return ResponseEntity.ok(GeneralResponse.exito(true));
    }
}
