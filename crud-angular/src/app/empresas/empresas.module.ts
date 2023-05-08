import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/shared/shared.module';

import { AppMaterialModule } from '../../shared/models/app-material/app-material.module';
import { EmpresaEditarComponent } from './empresa-editar/empresa-editar.component';
import { EmpresasRoutingModule } from './empresas-routing.module';
import { EmpresasComponent } from './empresas/empresas.component';



@NgModule({
  declarations: [
    EmpresasComponent,
    EmpresaEditarComponent
  ],
  imports: [
    CommonModule,
    EmpresasRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class EmpresasModule { }
