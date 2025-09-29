package co.com.polijic.cambridge.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMensajes {
    EXITO_OPERACION("Operación realizada con exito"),
    ERROR_GENERAL("Ocurrio un error realizando la operacion, por favor intente nuevamente.");

    private String valor;
}
