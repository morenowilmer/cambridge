import { Empleado } from './../data/models/empleado.model';
import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { EmpleadoService } from '../data/services/empleado.service';
import { tap } from 'rxjs';
import { Tipo } from '../data/models/tipos.model';
import { DropdownModule } from 'primeng/dropdown';
import { SalonClaseService } from '../data/services/salon-clase.service';
import { EstadoClase } from '../data/models/estado-clase.model';
import { OficinaService } from '../data/services/oficina.service';
import { Oficina } from '../data/models/oficina.model';
import { SalonClase } from '../data/models/salon-clase.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-empleados',
  standalone: true,
  imports: [
    TableModule,
    ToastModule,
    ButtonModule,
    DialogModule,
    DropdownModule,
    CalendarModule,
    InputTextModule,
    ConfirmDialogModule,
    ReactiveFormsModule,
  ],
  providers: [ConfirmationService, MessageService, DatePipe],
  templateUrl: './empleados.component.html',
  styleUrl: './empleados.component.scss',
})
export class EmpleadosComponent implements OnInit {
  public visible: boolean = false;
  public titleModal = 'Crear';
  public formulario: FormGroup;
  private fb: FormBuilder = inject(FormBuilder);

  private empleadoService: EmpleadoService = inject(EmpleadoService);
  private salonClaseService: SalonClaseService = inject(SalonClaseService);
  private oficinaService: OficinaService = inject(OficinaService);

  public datosTipoIdentificacion: Tipo[] = [];
  public datosTipoClasificacion: Tipo[] = [];
  public datosTipoProfesor: Tipo[] = [];
  public estadosEmpleados: EstadoClase[] = [];
  public datosOficinas: Oficina[] = [];
  public datosSalones: SalonClase[] = [];
  public datosEmpleados: Empleado[] = [];

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private datePipe: DatePipe
  ) {
    this.formulario = this.fb.group({
      id: [null],
      nombre: [null, [Validators.required]],
      apellido: [null, [Validators.required]],
      identificacion: [null, [Validators.required]],
      tipoIdentificacion: [null, [Validators.required]],
      fechaNacimiento: [null, [Validators.required]],
      celular: [null, [Validators.required]],
      correo: [null, [Validators.required, Validators.email]],
      direccion: [null, [Validators.required]],
      fechaVinculacion: [null, [Validators.required]],
      estado: [null, [Validators.required]],
      idOficina: [null, [Validators.required]],
      clasificacion: [null, [Validators.required]],
      idSalon: [{ value: null, disabled: true }],
      tipoProfesor: [{ value: null, disabled: true }],
    });
  }

  ngOnInit() {
    this.consultarTiposIdentificacion();
    this.consultarTiposClasificacion();
    this.consultarTiposProfesor();
    this.consultarEstadosEmpleados();
    this.consultarOficinas();
    this.consultarSalones();
    this.consultarEmpleados();

    this.formulario.get('clasificacion')?.valueChanges.subscribe((valor) => {
      this.cambioClasificacion(valor);
    });

    this.cambioClasificacion(this.formulario.get('clasificacion')?.value);
  }

  public cambioClasificacion(clasificacion: String | null) {
    if (clasificacion === 'PROFES') {
      this.formulario.get('idSalon')?.enable();
      this.formulario.get('tipoProfesor')?.enable();
      this.formulario.get('idSalon')?.setValidators([Validators.required]);
      this.formulario.get('tipoProfesor')?.setValidators([Validators.required]);
      //this.formulario.get('idSalon')?.updateValueAndValidity();
      //this.formulario.get('tipoProfesor')?.updateValueAndValidity();
    } else {
      this.formulario.get('idSalon')?.disable();
      this.formulario.get('tipoProfesor')?.disable();
      this.formulario.get('idSalon')?.clearValidators();
      this.formulario.get('tipoProfesor')?.clearValidators();
      //this.formulario.get('idSalon')?.updateValueAndValidity();
      //this.formulario.get('tipoProfesor')?.updateValueAndValidity();
    }
  }

  private consultarOficinas() {
    this.oficinaService
      .listarOficinas()
      .pipe(
        tap((res) => {
          this.datosOficinas = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  private consultarEstadosEmpleados() {
    this.salonClaseService
      .listarEstadoClase()
      .pipe(
        tap((res) => {
          this.estadosEmpleados = res.respuesta ?? [];
        })
      )
      .subscribe();
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

  private consultarEmpleados() {
    this.empleadoService
      .listarEmpleados()
      .pipe(
        tap((res) => {
          this.datosEmpleados = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  private consultarTiposIdentificacion() {
    this.empleadoService
      .listarTiposIdentificacion()
      .pipe(
        tap((res) => {
          this.datosTipoIdentificacion = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  private consultarTiposClasificacion() {
    this.empleadoService
      .listarTiposClasificacion()
      .pipe(
        tap((res) => {
          this.datosTipoClasificacion = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  private consultarTiposProfesor() {
    this.empleadoService
      .listarTiposProfesor()
      .pipe(
        tap((res) => {
          this.datosTipoProfesor = res.respuesta ?? [];
        })
      )
      .subscribe();
  }

  showDialog(empleado: Empleado = {} as Empleado) {
    this.visible = true;
    this.titleModal = Object.keys(empleado).length > 0 ? 'Editar' : 'Crear';
    if (Object.keys(empleado).length > 0) {
      this.formulario.patchValue(empleado);
    } else {
      this.formulario.reset();
    }
  }

  eliminarEmpleado(empleado: Empleado) {
    this.confirmationService.confirm({
      message: '¿Desea eliminar el empleado?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      acceptLabel: 'Si',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.empleadoService
          .eliminarEmpleado(empleado.id!)
          .pipe(
            tap((res) => {
              this.visible = false;
              this.formulario.reset();
              this.consultarEmpleados();
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

  guardarEmpleado() {
    var empleadoGuardar = this.formulario.getRawValue();
    if (empleadoGuardar.clasificacion === 'PROFES') {
      empleadoGuardar = {
        ...empleadoGuardar,
        fechaNacimiento: this.datePipe.transform(empleadoGuardar.fechaNacimiento, 'dd/MM/yyyy'),
        fechaVinculacion: this.datePipe.transform(empleadoGuardar.fechaVinculacion, 'dd/MM/yyyy'),
        profesorObjeto: {
          idSalon: empleadoGuardar.idSalon,
          tipoProfesor: empleadoGuardar.tipoProfesor
        }
      };
    }
    this.empleadoService
      .crearEditarEmpleado(empleadoGuardar)
      .pipe(
        tap((res) => {
          this.visible = false;
          this.formulario.reset();
          this.consultarEmpleados();
          this.messageService.add({
            severity: 'info',
            detail: res.mensaje,
          });
        })
      )
      .subscribe();
  }
}
