import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Empresa } from 'src/shared/models/empresa.model';
import { Resolve } from '../guards/resolve';

import { EmpresasService } from '../services/empresas.service';


@Injectable({
  providedIn: 'root'
})
export class EmpresaResolver implements Resolve<Empresa>  {

  constructor(private service: EmpresasService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Empresa>
  |Promise<Empresa>|Empresa  {
    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }
    return of({ id: 0, cnpj: '', nome: '', cep: '', logradouro: '', numero: 0,
                complemento: '', bairro: '', cidade: '', estado: ''});
  }
}
