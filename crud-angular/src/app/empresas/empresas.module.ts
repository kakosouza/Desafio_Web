import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpresasRoutingModule } from './empresas-routing.module';
import { EmpresasComponent } from './empresas/empresas.component';
import { AppMaterialModule } from '../../shared/models/app-material/app-material.module'



@NgModule({
  declarations: [
    EmpresasComponent
  ],
  imports: [
    CommonModule,
    EmpresasRoutingModule,
    AppMaterialModule
  ]
})
export class EmpresasModule { }
