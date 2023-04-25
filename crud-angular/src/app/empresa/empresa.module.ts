import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


import { EmpresaService } from './services/empresa.service';
import { ListarEmpresaComponent } from './listar-empresa/listar-empresa.component';
import { InserirEmpresaComponent } from './inserir-empresa/inserir-empresa.component';

@NgModule({
  declarations: [
    ListarEmpresaComponent,
    InserirEmpresaComponent
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