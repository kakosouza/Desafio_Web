import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EditarEmpresaComponent } from './empresa/editar-empresa/editar-empresa.component';
import { InserirEmpresaComponent } from './empresa/inserir-empresa/inserir-empresa.component';
import { ListarEmpresaComponent } from './empresa/listar-empresa/listar-empresa.component';
import { EditarFornecedorComponent } from './fornecedor/editar-fornecedor/editar-fornecedor.component';
import { InserirFornecedorComponent } from './fornecedor/inserir-fornecedor/inserir-fornecedor.component';
import { ListarFornecedorComponent } from './fornecedor/listar-fornecedor/listar-fornecedor.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'empresas/listar' },
  { path: 'empresas', redirectTo: 'empresas/listar' },
  { path: 'empresas/listar',
    component: ListarEmpresaComponent },
  { path: 'empresas/novo',
    component: InserirEmpresaComponent },
  { path: 'empresas/editar/:id',
    component: EditarEmpresaComponent },
  { path: 'fornecedores', redirectTo: 'fornecedores/listar' },
  { path: 'fornecedores/listar',
    component: ListarFornecedorComponent },
  { path: 'fornecedores/novo',
    component: InserirFornecedorComponent },
  { path: 'fornecedores/editar/:id',
    component: EditarFornecedorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
