import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/shared/shared.module';

import { AppMaterialModule } from '../../shared/models/app-material/app-material.module';
import { EmpresasListComponent } from './components/empresas-list/empresas-list.component';
import { EmpresasComponent } from './containers/empresas/empresas.component';
import { EmpresaEditarComponent } from './empresa-editar/empresa-editar.component';
import { EmpresaInserirComponent } from './empresa-inserir/empresa-inserir.component';
import { EmpresasRoutingModule } from './empresas-routing.module';
import { EmpresaLigarComponent } from './empresa-ligar/empresa-ligar.component';



@NgModule({
  declarations: [
    EmpresasComponent,
    EmpresaEditarComponent,
    EmpresasListComponent,
    EmpresaInserirComponent,
    EmpresaLigarComponent
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
