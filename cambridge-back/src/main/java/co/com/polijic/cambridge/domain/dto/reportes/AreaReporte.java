package co.com.polijic.cambridge.domain.dto.reportes;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaReporte implements Serializable {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String fechaCreacion;
    private String fechaFin;
}
