package co.com.polijic.cambridge.domain.common;

import co.com.polijic.cambridge.domain.enums.EnumCodigoRespuesta;
import co.com.polijic.cambridge.domain.enums.EnumMensajes;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T> {

    public String codigo;
    public String mensaje;
    public T respuesta;

    public static <T> GeneralResponse<T> exito(T respuesta) {
        return new GeneralResponse<>(EnumCodigoRespuesta.EXITO.getValor(), EnumMensajes.EXITO_OPERACION.getValor(), respuesta);
    }

    public static <T> GeneralResponse<T> error(T respuesta) {
        return new GeneralResponse<>(EnumCodigoRespuesta.ERROR.getValor(), EnumMensajes.ERROR_GENERAL.getValor(), respuesta);
    }
}
