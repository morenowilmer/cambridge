package co.com.polijic.cambridge.controller;

import co.com.polijic.cambridge.adapter.port.SalonClasePort;
import co.com.polijic.cambridge.domain.common.GeneralResponse;
import co.com.polijic.cambridge.domain.dto.SalonClaseDto;
import co.com.polijic.cambridge.domain.dto.TipoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/salon-clase")
public class SalonClaseController {

    private final SalonClasePort salonClasePort;

    public SalonClaseController(SalonClasePort salonClasePort) {
        this.salonClasePort = salonClasePort;
    }

    @ResponseBody
    @GetMapping(value = "/listar", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<SalonClaseDto>>> consultarSalonesClase() {
        List<SalonClaseDto> response = salonClasePort.consultarSalonesClase();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @PostMapping(value = "/guardar", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GeneralResponse<SalonClaseDto>> guardarSalonClase(@RequestBody SalonClaseDto salonClase) {
        try {
            SalonClaseDto response = salonClasePort.guardarSalonClase(salonClase);

            return ResponseEntity.ok(GeneralResponse.exito(response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.error(null));
        }
    }

    @ResponseBody
    @GetMapping(value = "/consultar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<SalonClaseDto>> consultarSalonClase(@PathVariable("id") Integer id) {
        SalonClaseDto response = salonClasePort.consultarSalonClase(id);

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }

    @ResponseBody
    @DeleteMapping(value = "/eliminar/{id}", produces = "application/json")
    public ResponseEntity<GeneralResponse<Boolean>> eliminarSalonClase(@PathVariable("id") Integer id) {
        try {
            salonClasePort.eliminarSalonClase(id);

            return ResponseEntity.ok(GeneralResponse.exito(true));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(GeneralResponse.error(false));
        }
    }

    @ResponseBody
    @GetMapping(value = "/estados", produces = "application/json")
    public ResponseEntity<GeneralResponse<List<TipoDto>>> consultarEstadosSalonClase() {
        List<TipoDto> response = salonClasePort.consultarEstadosSalonClase();

        return ResponseEntity.ok(GeneralResponse.exito(response));
    }
}
