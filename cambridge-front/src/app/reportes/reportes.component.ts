import { CommonModule, isPlatformBrowser } from '@angular/common';
import { ReporteService } from './../data/services/reporte.service';
import { Component, Inject, inject, PLATFORM_ID } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { tap } from 'rxjs';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [
    ButtonModule,
    CommonModule,
  ],
  templateUrl: './reportes.component.html',
  styleUrl: './reportes.component.scss',
})
export class ReportesComponent {
  private reporteBase64: string = '';
  private ReporteService: ReporteService = inject(ReporteService);

  pdfSrc: SafeResourceUrl | null = null;
  errorMessage: string | null = null

  constructor(private sanitizer: DomSanitizer) {
  }

  public generarReporte() {
    this.ReporteService.generarReporte()
      .pipe(
        tap((res) => {
          this.reporteBase64 = res.respuesta ?? '';
          if (this.reporteBase64) {
            this.cargarPdf(this.reporteBase64);
          }
        })
      )
      .subscribe();
  }

  limpiarPdf(): void {
    this.pdfSrc = null;
    this.errorMessage = null;
  }

  cargarPdf(base64Content: string): void {
    this.errorMessage = null;
    if (!base64Content) {
      this.errorMessage = 'El string Base64 del PDF está vacío.';
      this.pdfSrc = null;
      return;
    }

    let cleanBase64 = base64Content;
    if (cleanBase64.includes(';base64,')) {
      cleanBase64 = cleanBase64.split(',')[1];
    }

    try {
      const dataUrl = `data:application/pdf;base64,${cleanBase64}`;
      this.pdfSrc = this.sanitizer.bypassSecurityTrustResourceUrl(dataUrl);
    } catch (e) {
      this.errorMessage = 'No se pudo cargar el PDF. Asegúrate de que el Base64 es válido.';
      console.error('Error al cargar el PDF Base64:', e);
      this.pdfSrc = null;
    }
  }
}
