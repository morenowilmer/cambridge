package co.com.polijic.cambridge.repository.entities;

import co.com.polijic.cambridge.domain.dto.OficinaDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "salon_clase")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String tipoIdentificacion;
    private LocalDate fechaNacimiento;
    private String celular;
    private String correo;
    private String direccion;
    private LocalDate fechaVinculacion;
    private String clasificacion;
    private String estado;
    private String idOficina;
    private OficinaDto oficina;
}
