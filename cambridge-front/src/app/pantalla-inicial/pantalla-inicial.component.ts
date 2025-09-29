import { Component } from '@angular/core';
import { FieldsetModule } from 'primeng/fieldset';
import { TabViewModule } from 'primeng/tabview';
import { AreaComponent } from '../area/area.component';
import { EmpleadosComponent } from '../empleados/empleados.component';
import { OficinaComponent } from '../oficina/oficina.component';
import { ReportesComponent } from '../reportes/reportes.component';
import { SalonesComponent } from '../salones/salones.component';

@Component({
  selector: 'app-pantalla-inicial',
  standalone: true,
  imports: [
    FieldsetModule,
    TabViewModule,
    AreaComponent,
    EmpleadosComponent,
    OficinaComponent,
    ReportesComponent,
    SalonesComponent,
  ],
  templateUrl: './pantalla-inicial.component.html',
  styleUrl: './pantalla-inicial.component.scss',
})
export class PantallaInicialComponent {
  activeIndex: number = 0;
}
