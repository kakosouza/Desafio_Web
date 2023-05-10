import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//import { EmpresaResolver } from './empresas/guards/empresa.resolver';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'empresas' },
  { path: 'empresas', loadChildren: () => import('./empresas/empresas.module').then(m => m.EmpresasModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
