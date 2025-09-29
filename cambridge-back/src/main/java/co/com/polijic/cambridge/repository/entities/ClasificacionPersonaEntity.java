package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "clasificacion_persona")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionPersonaEntity implements Serializable {

    @Id
    private String codigo;
    private String nombre;
    private String descripcion;
}
