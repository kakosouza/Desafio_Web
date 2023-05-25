import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmpresasComponent } from './containers/empresas/empresas.component';
import { EmpresaEditarComponent } from './empresa-editar/empresa-editar.component';
import { EmpresaInserirComponent } from './empresa-inserir/empresa-inserir.component';
import { EmpresaLigarComponent } from './empresa-ligar/empresa-ligar.component';
import { EmpresaResolver } from './guards/empresa.resolver';

const routes: Routes = [
  { path: '', component: EmpresasComponent},
  { path: 'new', component: EmpresaInserirComponent, resolve: { empresa: EmpresaResolver}},
  { path: 'edit/:id', component: EmpresaEditarComponent, resolve: { empresa: EmpresaResolver}},
  { path: 'fornec/:id', component: EmpresaLigarComponent, resolve: { empresa: EmpresaResolver}},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresasRoutingModule { }
