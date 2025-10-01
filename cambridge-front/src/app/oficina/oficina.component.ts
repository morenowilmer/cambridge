import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { Oficina } from '../data/models/oficina.model';
import { tap } from 'rxjs';
import { OficinaService } from '../data/services/oficina.service';
import { AreaService } from '../data/services/area.service';
import { Area } from '../data/models/area.model';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-oficina',
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
  templateUrl: './oficina.component.html',
  styleUrl: './oficina.component.scss',
})
export class OficinaComponent implements OnInit {
  public visible: boolean = false;
  public titleModal = 'Crear';
  public formulario: FormGroup;
  private fb: FormBuilder = inject(FormBuilder);

  public datosOficina: Oficina[] = [];
  public datosArea: Area[] = [];
  private oficinaService: OficinaService = inject(OficinaService);
  private areaService: AreaService = inject(AreaService);

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService
  ) {
    this.formulario = this.fb.group({
      id: [null],
      nombre: [null, [Validators.required]],
      descripcion: [null, [Validators.required]],
      idArea: [null, [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.consultarOficinas();
    this.consultarAreas();
  }

  private consultarOficinas() {
    this.oficinaService
      .listarOficinas()
      .pipe(
        tap((res) => {
          this.datosOficina = res.respuesta ?? [];
        })
      )
      .subscribe();
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

  showDialog(oficina: Oficina = {} as Oficina) {
    this.visible = true;
    this.titleModal = Object.keys(oficina).length > 0 ? 'Editar' : 'Crear';
    if (Object.keys(oficina).length > 0) {
      this.formulario.patchValue(oficina);
    } else {
      this.formulario.reset();
    }
  }

  guardarOficina() {
    this.oficinaService
      .crearEditarOficina(this.formulario.getRawValue())
      .pipe(
        tap((res) => {
          this.visible = false;
          this.formulario.reset();
          this.consultarOficinas();
          this.messageService.add({
            severity: 'info',
            detail: res.mensaje,
          });
        })
      )
      .subscribe();
  }

  eliminarOficina(oficina: Oficina) {
    this.confirmationService.confirm({
      message: '¿Desea eliminar la oficina?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      acceptLabel: 'Si',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.oficinaService
          .eliminarOficina(oficina.id!)
          .pipe(
            tap((res) => {
              this.visible = false;
              this.formulario.reset();
              this.consultarOficinas();
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
