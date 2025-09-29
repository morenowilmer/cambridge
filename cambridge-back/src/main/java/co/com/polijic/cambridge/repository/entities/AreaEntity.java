package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "area")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
}
