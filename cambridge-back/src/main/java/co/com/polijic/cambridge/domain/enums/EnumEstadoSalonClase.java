package co.com.polijic.cambridge.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumEstadoSalonClase {
    ACTIVO("ACTIVO", "Activo"),
    INACTIVO("INACTIVO", "Inactivo");

    private String codigo;
    private String titulo;
}
