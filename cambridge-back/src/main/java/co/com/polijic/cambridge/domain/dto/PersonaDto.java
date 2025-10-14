package co.com.polijic.cambridge.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String identificacion;
    private String tipoIdentificacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    private String celular;
    private String correo;
    private String direccion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaVinculacion;
    private String estado;
    private Integer idOficina;
    private String clasificacion;
    private OficinaDto oficinaObjeto;
    private TipoDto tipoIdentificacionObjeto;
    private TipoDto tipoClasificacionObjeto;
    private ProfesorDto profesorObjeto;
}
