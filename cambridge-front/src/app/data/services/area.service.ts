import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Area } from '../models/area.model';
import { ApiResponse } from '../models/general-response.model';

@Injectable({
  providedIn: 'root',
})
export class AreaService {
  private urlBase = environment.url + 'area/';
  private httpClient: HttpClient = inject(HttpClient);

  constructor() {}

  public listarArea(): Observable<ApiResponse<Area[]>> {
    return this.httpClient.get<ApiResponse<Area[]>>(this.urlBase + 'listar');
  }

  public crearEditarArea(area: Area): Observable<ApiResponse<Area[]>> {
    return this.httpClient.post<ApiResponse<Area[]>>(
      this.urlBase + 'guardar',
      area
    );
  }
  public eliminarArea(id: number): Observable<ApiResponse<boolean>> {
    return this.httpClient.delete<ApiResponse<boolean>>(
      this.urlBase + 'eliminar/' + id
    );
  }
}
