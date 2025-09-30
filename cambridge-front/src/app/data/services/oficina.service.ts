import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/general-response.model';
import { Oficina } from '../models/oficina.model';

@Injectable({
  providedIn: 'root',
})
export class OficinaService {
  private urlBase = environment.url + 'oficina/';
  private httpClient: HttpClient = inject(HttpClient);

  constructor() {}

  public listarOficinas(): Observable<ApiResponse<Oficina[]>> {
    return this.httpClient.get<ApiResponse<Oficina[]>>(this.urlBase + 'listar');
  }

  public crearEditarOficina(
    oficina: Oficina
  ): Observable<ApiResponse<Oficina[]>> {
    return this.httpClient.post<ApiResponse<Oficina[]>>(
      this.urlBase + 'guardar',
      oficina
    );
  }
  
  public eliminarOficina(id: number): Observable<ApiResponse<boolean>> {
    return this.httpClient.delete<ApiResponse<boolean>>(
      this.urlBase + 'eliminar/' + id
    );
  }
}
