import { Component, inject, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Area } from '../data/models/area.model';
import { ButtonModule } from 'primeng/button';
import { AreaService } from '../data/services/area.service';
import { tap } from 'rxjs';
import { DialogModule } from 'primeng/dialog';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-area',
  standalone: true,
  imports: [
    TableModule,
    ToastModule,
    ButtonModule,
    DialogModule,
    CalendarModule,
    InputTextModule,
    ConfirmDialogModule,
    ReactiveFormsModule,
  ],
  providers: [ConfirmationService, MessageService],
  templateUrl: './area.component.html',
  styleUrl: './area.component.scss',
})
export class AreaComponent implements OnInit {
  public visible: boolean = false;
  public titleModal = 'Crear';
  public formulario: FormGroup;
  private fb: FormBuilder = inject(FormBuilder);

  public datosArea: Area[] = [];
  private areaService: AreaService = inject(AreaService);

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService
  ) {
    this.formulario = this.fb.group({
      id: [null],
      nombre: [null, [Validators.required]],
      descripcion: [null, [Validators.required]],
      fechaCreacion: [{ value: null, disabled: true }],
      fechaFin: [null],
    });
  }

  ngOnInit(): void {
    this.consultarAreas();
  }
  private consultarAreas() {
    this.areaService
      .listarArea()
      .pipe(
        tap((res) => {
          this.datosArea = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  showDialog(area: Area = {} as Area) {
    this.visible = true;
    this.titleModal = Object.keys(area).length > 0 ? 'Editar' : 'Crear';
    if (Object.keys(area).length > 0) {
      this.formulario.patchValue(area);
    } else {
      this.formulario.reset();
    }
  }

  guardarArea() {
    this.areaService
      .crearEditarArea(this.formulario.getRawValue())
      .pipe(
        tap((res) => {
          this.visible = false;
          this.formulario.reset();
          this.consultarAreas();
          this.messageService.add({
            severity: 'info',
            detail: res.mensaje,
          });
        })
      )
      .subscribe();
  }

  eliminarArea(area: Area) {
    this.confirmationService.confirm({
      message: '¿Desea eliminar el área?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      acceptLabel: 'Si',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.areaService
          .eliminarArea(area.id!)
          .pipe(
            tap((res) => {
              this.visible = false;
              this.formulario.reset();
              this.consultarAreas();
              this.messageService.add({
                severity: 'info',
                detail: res.mensaje,
              });
            })
          )
          .subscribe();
      },
    });
  }
}
