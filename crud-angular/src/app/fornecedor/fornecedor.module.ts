import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { FornecedorService } from './services/fornecedor.service';
import { ListarFornecedorComponent } from './listar-fornecedor/listar-fornecedor.component';

@NgModule({
  declarations: [
    ListarFornecedorComponent
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
