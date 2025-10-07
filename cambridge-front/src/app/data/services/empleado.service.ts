import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/general-response.model';
import { Tipo } from '../models/tipos.model';
import { Empleado } from '../models/empleado.model';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private urlBase = environment.url + 'persona/';
    private httpClient: HttpClient = inject(HttpClient);

  constructor() { }

  public listarTiposIdentificacion(): Observable<ApiResponse<Tipo[]>> {
    return this.httpClient.get<ApiResponse<Tipo[]>>(this.urlBase + 'tipos-identificacion');
  }

  public listarTiposClasificacion(): Observable<ApiResponse<Tipo[]>> {
    return this.httpClient.get<ApiResponse<Tipo[]>>(this.urlBase + 'tipos-clasificacion');
  }

  public listarTiposProfesor(): Observable<ApiResponse<Tipo[]>> {
    return this.httpClient.get<ApiResponse<Tipo[]>>(this.urlBase + 'tipos-profesor');
  }

  public listarEmpleados(): Observable<ApiResponse<Empleado[]>> {
    return this.httpClient.get<ApiResponse<Empleado[]>>(this.urlBase + 'listar');
  }

  public crearEditarEmpleado(empleado: Empleado): Observable<ApiResponse<Empleado[]>> {
    return this.httpClient.post<ApiResponse<Empleado[]>>(this.urlBase + 'guardar', empleado);
  }

  public eliminarEmpleado(id: number): Observable<ApiResponse<boolean>> {
    return this.httpClient.delete<ApiResponse<boolean>>(this.urlBase + 'eliminar/' + id);
  } 
}
