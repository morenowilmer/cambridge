package co.com.polijic.cambridge.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String apellido;
    private String tipoIdentificacion;
    private LocalDate fechaNacimiento;
    private String celular;
    private String correo;
    private String direccion;
    private LocalDate fechaVinculacion;
    private String estado;
    private String idOficina;
    private String clasificacion;
    private OficinaDto oficinaDto;
    private TipoDto tipoIdentificacionObjeto;
    private TipoDto tipoClasificacionObjeto;
}
