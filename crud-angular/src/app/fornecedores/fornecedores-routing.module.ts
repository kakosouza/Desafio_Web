import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FornecedoresComponent } from '../fornecedores/containers/fornecedores/fornecedores.component';
import { FornecedorEditarComponent } from '../fornecedores/fornecedor-editar/fornecedor-editar.component';
import { FornecedorInserirComponent } from '../fornecedores/fornecedor-inserir/fornecedor-inserir.component';
import { FornecedorResolver } from '../fornecedores/guards/fornecedor.resolver';

const routes: Routes = [
  { path: '', component: FornecedoresComponent},
  { path: 'new', component: FornecedorInserirComponent, resolve: { fornecedor: FornecedorResolver}},
  { path: 'edit/:id', component: FornecedorEditarComponent, resolve: { fornecedor: FornecedorResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FornecedoresRoutingModule { }
