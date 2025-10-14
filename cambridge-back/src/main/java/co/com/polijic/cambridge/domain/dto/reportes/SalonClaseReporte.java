package co.com.polijic.cambridge.domain.dto.reportes;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalonClaseReporte implements Serializable {

    private Integer id;
    private String bloque;
    private String numeroSalon;
    private Integer capacidad;
    private String grado;
    private String estado;
}
