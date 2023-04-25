import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListarEmpresaComponent } from './empresa/listar-empresa/listar-empresa.component';
import { ListarFornecedorComponent } from './fornecedor/listar-fornecedor/listar-fornecedor.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'empresas/listar' },
  { path: 'empresas', redirectTo: 'empresas/listar' },
  { path: 'empresas/listar',
    component: ListarEmpresaComponent },
  { path: 'fornecedores', redirectTo: 'fornecedores/listar' },
  { path: 'fornecedores/listar',
    component: ListarFornecedorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
