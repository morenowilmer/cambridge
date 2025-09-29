package co.com.polijic.cambridge.domain.common;

import co.com.polijic.cambridge.domain.enums.EnumCodigoRespuesta;
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
        return new GeneralResponse<>(EnumCodigoRespuesta.EXITO.getValor(), "Operación realizada con exito", respuesta);
    }

    public static <T> GeneralResponse<T> error(String mensaje) {
        return new GeneralResponse<>(EnumCodigoRespuesta.ERROR.getValor(), mensaje, null);
    }
}
