import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { EditarFornecedorComponent } from './editar-fornecedor/editar-fornecedor.component';
import { InserirFornecedorComponent } from './inserir-fornecedor/inserir-fornecedor.component';
import { ListarFornecedorComponent } from './listar-fornecedor/listar-fornecedor.component';
import { FornecedorService } from './services/fornecedor.service';

@NgModule({
  declarations: [
    ListarFornecedorComponent,
    InserirFornecedorComponent,
    EditarFornecedorComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    FornecedorService
  ]
})
export class FornecedorModule { }
