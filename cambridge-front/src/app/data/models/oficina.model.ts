import { Area } from "./area.model";

export interface Oficina {
    id: number | null;
    nombre: string;
    descripcion: string;
    idArea: number | null;
    area: Area | null;
}