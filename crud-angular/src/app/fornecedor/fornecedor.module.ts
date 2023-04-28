import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
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
    RouterModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatTableModule
  ],
  providers: [
    FornecedorService
  ]
})
export class FornecedorModule { }
