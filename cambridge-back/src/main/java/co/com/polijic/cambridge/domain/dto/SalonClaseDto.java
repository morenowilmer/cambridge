package co.com.polijic.cambridge.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalonClaseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String bloque;
    private String numeroSalon;
    private Integer capacidad;
    private String grado;
    private String estado;
    private String labelEstado;
}
