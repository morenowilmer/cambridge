package co.com.polijic.cambridge.controller;

import co.com.polijic.cambridge.adapter.port.ReportesPort;
import co.com.polijic.cambridge.domain.common.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reporte")
public class ReportesController {

    private final ReportesPort reportesPort;

    public ReportesController(ReportesPort reportesPort) {
        this.reportesPort = reportesPort;
    }

    @ResponseBody
    @GetMapping("/generar")
    public ResponseEntity<GeneralResponse<String>> generarReporte() {
        return ResponseEntity.ok(GeneralResponse.exito(reportesPort.generarReporte()));
    }
}
