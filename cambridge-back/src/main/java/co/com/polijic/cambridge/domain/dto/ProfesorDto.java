package co.com.polijic.cambridge.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer idPersona;
    private Integer idSalon;
    private String tipoProfesor;
    private TipoDto tipoProfesorObjeto;
    private SalonClaseDto salonClaseObjeto;
}
