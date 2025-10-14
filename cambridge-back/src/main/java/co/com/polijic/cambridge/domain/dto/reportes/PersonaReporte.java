package co.com.polijic.cambridge.domain.dto.reportes;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaReporte implements Serializable {

    private Integer id;
    private String nombreCompleto;
    private String identificacion;
    private String tipoIdentificacion;
    private String correo;
    private String estado;
    private String oficina;
    private String clasificacion;
    private String numeroSalon;
    private String tipoProfesor;
}
