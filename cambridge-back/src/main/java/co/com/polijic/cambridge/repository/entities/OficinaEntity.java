package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "oficina")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OficinaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer idArea;
}
