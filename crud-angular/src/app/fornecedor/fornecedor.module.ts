import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { ListarFornecedorComponent } from './listar-fornecedor/listar-fornecedor.component';
import { FornecedorService } from './services/fornecedor.service';

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
