import { ApiResponse } from './../models/general-response.model';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {
  private urlBase = environment.url + 'reporte/';
    private httpClient: HttpClient = inject(HttpClient);

  constructor() { }

  public generarReporte(): Observable<ApiResponse<string>> {
    return this.httpClient.get<ApiResponse<string>>(this.urlBase + 'generar');
  }
}
