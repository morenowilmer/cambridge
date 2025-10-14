package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "profesor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idPersona;
    @Column(name = "ID_SALON_CLASE")
    private Integer idSalon;
    private String tipoProfesor;
}
