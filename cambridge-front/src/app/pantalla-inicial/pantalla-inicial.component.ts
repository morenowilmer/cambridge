import { Component } from '@angular/core';
import { FieldsetModule } from 'primeng/fieldset';
import { TabViewModule } from 'primeng/tabview';

@Component({
  selector: 'app-pantalla-inicial',
  standalone: true,
  imports: [FieldsetModule, TabViewModule],
  templateUrl: './pantalla-inicial.component.html',
  styleUrl: './pantalla-inicial.component.scss',
})
export class PantallaInicialComponent {
  activeIndex: number = 0;
}
