import { Oficina } from "./oficina.model";
import { SalonClase } from "./salon-clase.model";
import { Tipo } from "./tipos.model";

export interface profesor {
    id: number | null;
    idPersona: number;
    idSalon: number;
    tipoProfesor: string;
    tipoProfesorObjeto: Tipo | null;
    salonClaseObjeto: SalonClase | null;
}

export interface Empleado {
    id: number | null;
    nombre: string;
    apellido: string;
    identificacion: string;
    tipoIdentificacion: string;
    fechaNacimiento: string;
    celular: string;
    correo: string;
    direccion: string;
    fechaVinculacion: string;
    estado: string;
    idOficina: number | null;
    clasificacion: string;
    oficinaObjeto: Oficina | null;
    tipoIdentificacionObjeto: Tipo | null;
    tipoClasificacionObjeto: Tipo | null;
    profesorObjeto: profesor | null;
}