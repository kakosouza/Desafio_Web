import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmpresaInserirComponent } from './empresa-inserir/empresa-inserir.component';
import { EmpresasComponent } from './empresas/empresas.component';

const routes: Routes = [
  { path: '', component: EmpresasComponent},
  { path: 'new', component: EmpresaInserirComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresasRoutingModule { }
