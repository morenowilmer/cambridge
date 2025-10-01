package co.com.polijic.cambridge.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "salon_clase")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalonClaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bloque;
    private String numeroSalon;
    private Integer capacidad;
    private String grado;
    private String estado;
}
