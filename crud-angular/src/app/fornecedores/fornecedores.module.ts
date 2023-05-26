import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/shared/shared.module';

import { AppMaterialModule } from '../../shared/models/app-material/app-material.module';
import { FornecedoresListComponent } from '../fornecedores/components/fornecedores-list/fornecedores-list.component';
import { FornecedoresComponent } from '../fornecedores/containers/fornecedores/fornecedores.component';
import { FornecedorEditarComponent } from '../fornecedores/fornecedor-editar/fornecedor-editar.component';
import { FornecedorInserirComponent } from '../fornecedores/fornecedor-inserir/fornecedor-inserir.component';
import { FornecedoresRoutingModule } from '../fornecedores/fornecedores-routing.module';

@NgModule({
  declarations: [
    FornecedoresComponent,
    FornecedoresListComponent,
    FornecedorEditarComponent,
    FornecedorInserirComponent
  ],
  imports: [
    CommonModule,
    FornecedoresRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class FornecedoresModule { }
