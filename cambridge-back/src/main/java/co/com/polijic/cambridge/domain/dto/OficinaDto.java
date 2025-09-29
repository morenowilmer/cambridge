package co.com.polijic.cambridge.domain.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer idArea;
    private AreaDto area;
}
