package co.com.polijic.cambridge.domain.dto.reportes;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OficinaReporte implements Serializable {

    private Integer idOficina;
    private String nombre;
    private String descripcion;
    private String nombreArea;
}
