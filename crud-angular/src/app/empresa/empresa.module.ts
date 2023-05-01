import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { NumericoDirective } from '../shared/directives/numerico.directive';
import { AppMaterialModule } from '../shared/models/app-material/app-material.module';
//import { EditarEmpresaComponent } from './editar-empresa/editar-empresa.component';
import { InserirEmpresaComponent } from './inserir-empresa/inserir-empresa.component';
import { ListarEmpresaComponent } from './listar-empresa/listar-empresa.component';
import { EmpresaService } from './services/empresa.service';

@NgModule({
  declarations: [
    ListarEmpresaComponent,
    InserirEmpresaComponent,
//    EditarEmpresaComponent,
    NumericoDirective
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    AppMaterialModule
  ],
  providers: [
    EmpresaService
  ]
})
export class EmpresaModule { }
