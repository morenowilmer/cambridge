import { ConfirmationService, MessageService } from 'primeng/api';
import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { SalonClase } from '../data/models/salon-clase.model';
import { EstadoClase } from '../data/models/estado-clase.model';
import { SalonClaseService } from '../data/services/salon-clase.service';
import { tap } from 'rxjs';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-salones',
  standalone: true,
  imports: [
    TableModule,
    ToastModule,
    ButtonModule,
    DialogModule,
    DropdownModule,
    InputTextModule,
    ConfirmDialogModule,
    ReactiveFormsModule,
  ],
  providers: [ConfirmationService, MessageService],
  templateUrl: './salones.component.html',
  styleUrl: './salones.component.scss',
})
export class SalonesComponent implements OnInit {
  public visible: boolean = false;
  public titleModal = 'Crear';
  public formulario: FormGroup;
  private fb: FormBuilder = inject(FormBuilder);

  public datosSalones: SalonClase[] = [];
  public estadosClase: EstadoClase[] = [];
  private salonClaseService = inject(SalonClaseService);

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService
  ) {
    this.formulario = this.fb.group({
      id: [null],
      bloque: [null, [Validators.required]],
      numeroSalon: [null, [Validators.required]],
      capacidad: [null, [Validators.required]],
      grado: [null, [Validators.required]],
      estado: [null, [Validators.required]],
    });
  }

  ngOnInit() {
    this.consultarSalones();
    this.consultarEstadosClase();
  }

  private consultarSalones() {
    this.salonClaseService
      .listarSalonClase()
      .pipe(
        tap((res) => {
          this.datosSalones = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  private consultarEstadosClase() {
    this.salonClaseService
      .listarEstadoClase()
      .pipe(
        tap((res) => {
          this.estadosClase = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  showDialog(salonClase: SalonClase = {} as SalonClase) {
    this.visible = true;
    this.titleModal = Object.keys(salonClase).length > 0 ? 'Editar' : 'Crear';
    if (Object.keys(salonClase).length > 0) {
      this.formulario.patchValue(salonClase);
    } else {
      this.formulario.reset();
    }
  }

  guardarSalonClase() {
    this.salonClaseService
      .crearEditarSalonClase(this.formulario.getRawValue())
      .pipe(
        tap((res) => {
          this.visible = false;
          this.formulario.reset();
          this.consultarSalones();
          this.messageService.add({
            severity: 'info',
            detail: res.mensaje,
          });
        })
      )
      .subscribe();
  }

  eliminarSalon(salon: SalonClase) {
    this.confirmationService.confirm({
      message: '¿Desea eliminar el salón?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      acceptLabel: 'Si',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.salonClaseService
          .eliminarSalonClase(salon.id!)
          .pipe(
            tap((res) => {
              this.visible = false;
              this.formulario.reset();
              this.consultarSalones();
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
