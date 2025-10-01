import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/general-response.model';
import { SalonClase } from '../models/salon-clase.model';
import { EstadoClase } from '../models/estado-clase.model';

@Injectable({
  providedIn: 'root',
})
export class SalonClaseService {
  private urlBase = environment.url + 'salon-clase/';
  private httpClient: HttpClient = inject(HttpClient);

  constructor() {}

  public listarSalonClase(): Observable<ApiResponse<SalonClase[]>> {
    return this.httpClient.get<ApiResponse<SalonClase[]>>(
      this.urlBase + 'listar'
    );
  }

  public crearEditarSalonClase(
    salonClase: SalonClase
  ): Observable<ApiResponse<SalonClase[]>> {
    return this.httpClient.post<ApiResponse<SalonClase[]>>(
      this.urlBase + 'guardar',
      salonClase
    );
  }

  public eliminarSalonClase(id: number): Observable<ApiResponse<boolean>> {
    return this.httpClient.delete<ApiResponse<boolean>>(
      this.urlBase + 'eliminar/' + id
    );
  }

  public listarEstadoClase(): Observable<ApiResponse<EstadoClase[]>> {
    return this.httpClient.get<ApiResponse<EstadoClase[]>>(
      this.urlBase + 'estados'
    );
  }
}
