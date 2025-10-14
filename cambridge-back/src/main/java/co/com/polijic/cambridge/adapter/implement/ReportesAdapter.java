package co.com.polijic.cambridge.adapter.implement;

import co.com.polijic.cambridge.adapter.port.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportesAdapter implements ReportesPort {

    private final AreaPort areaPort;
    private final OficinaPort oficinaPort;
    private final SalonClasePort salonClasePort;
    private final PersonaPort personaPort;
    private final ResourceLoader resourceLoader;

    private static final String RUTA_RESOURCES = "classpath:reportes/";

    public ReportesAdapter(AreaPort areaPort,
                           OficinaPort oficinaPort,
                           SalonClasePort salonClasePort,
                           PersonaPort personaPort,
                           ResourceLoader resourceLoader) {
        this.areaPort = areaPort;
        this.oficinaPort = oficinaPort;
        this.salonClasePort = salonClasePort;
        this.personaPort = personaPort;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String generarReporte() {
        try {
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String rutaArchivo = RUTA_RESOURCES + "reporte_cambridge.jrxml";
            String rutaLogo = RUTA_RESOURCES + "logo_cambridge.png";
            InputStream reporteStream = resourceLoader.getResource(rutaArchivo).getInputStream();
            InputStream logoReporte = resourceLoader.getResource(rutaLogo).getInputStream();
            JasperReport plantilla = JasperCompileManager.compileReport(reporteStream);

            JRBeanCollectionDataSource listaAreas = new JRBeanCollectionDataSource(areaPort.consultarAreasReporte());
            JRBeanCollectionDataSource listaOficinas = new JRBeanCollectionDataSource(oficinaPort.consultarOficnasReporte());
            JRBeanCollectionDataSource listaSalones = new JRBeanCollectionDataSource(salonClasePort.consultarSalonesClaseReporte());
            JRBeanCollectionDataSource listaPersonas = new JRBeanCollectionDataSource(personaPort.consultarReportePersonas());
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fechaReporte", formatoFecha.format(LocalDateTime.now()));
            parametros.put("listaAreas", listaAreas);
            parametros.put("listaOficinas", listaOficinas);
            parametros.put("listaSalones", listaSalones);
            parametros.put("listaPersonas", listaPersonas);
            parametros.put("logoReporte", logoReporte);
            JasperPrint reporte = JasperFillManager.fillReport(plantilla, parametros, new JREmptyDataSource());
            return Base64.getEncoder().encodeToString(JasperExportManager.exportReportToPdf(reporte));
        } catch (Exception e) {
            return "";
        }
    }
}
