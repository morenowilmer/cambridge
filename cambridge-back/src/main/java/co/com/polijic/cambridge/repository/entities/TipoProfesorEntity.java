package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tipo_profesor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoProfesorEntity implements Serializable {

    @Id
    private String codigo;
    private String nombre;
    private String descripcion;
}
