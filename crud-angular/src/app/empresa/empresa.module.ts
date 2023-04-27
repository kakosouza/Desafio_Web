import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { EditarEmpresaComponent } from './editar-empresa/editar-empresa.component';
import { InserirEmpresaComponent } from './inserir-empresa/inserir-empresa.component';
import { ListarEmpresaComponent } from './listar-empresa/listar-empresa.component';
import { EmpresaService } from './services/empresa.service';
import { NumericoDirective } from '../shared/directives/numerico.directive';

@NgModule({
  declarations: [
    ListarEmpresaComponent,
    InserirEmpresaComponent,
    EditarEmpresaComponent,
    NumericoDirective
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    EmpresaService
  ]
})
export class EmpresaModule { }
