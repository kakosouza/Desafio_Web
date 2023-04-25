import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InserirEmpresaComponent } from './empresa/inserir-empresa/inserir-empresa.component';
import { ListarEmpresaComponent } from './empresa/listar-empresa/listar-empresa.component';
import { InserirFornecedorComponent } from './fornecedor/inserir-fornecedor/inserir-fornecedor.component';
import { ListarFornecedorComponent } from './fornecedor/listar-fornecedor/listar-fornecedor.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'empresas/listar' },
  { path: 'empresas', redirectTo: 'empresas/listar' },
  { path: 'empresas/listar',
    component: ListarEmpresaComponent },
  { path: 'empresas/novo',
    component: InserirEmpresaComponent },
  { path: 'fornecedores', redirectTo: 'fornecedores/listar' },
  { path: 'fornecedores/listar',
    component: ListarFornecedorComponent },
  { path: 'fornecedores/novo',
    component: InserirFornecedorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
