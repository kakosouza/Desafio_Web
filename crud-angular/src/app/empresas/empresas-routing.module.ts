import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmpresaEditarComponent } from './empresa-editar/empresa-editar.component';
import { EmpresasComponent } from './containers/empresas/empresas.component';

const routes: Routes = [
  { path: '', component: EmpresasComponent},
  { path: 'new', component: EmpresaEditarComponent},
  { path: 'edit/:id', component: EmpresaEditarComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresasRoutingModule { }
