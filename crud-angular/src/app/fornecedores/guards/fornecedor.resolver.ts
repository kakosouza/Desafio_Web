import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Fornecedor } from 'src/shared/models/fornecedor.model';

import { Resolve } from '../../fornecedores/guards/resolve';
import { FornecedoresService } from '../services/fornecedores.service';


@Injectable({
  providedIn: 'root'
})
export class FornecedorResolver implements Resolve<Fornecedor>  {

  constructor(private service: FornecedoresService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Fornecedor>
  |Promise<Fornecedor>|Fornecedor  {
    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }
    return of({ id: 0, chave: '', nome: '', cep: '', logradouro: '', numero: 0,
                complemento: '', bairro: '', cidade: '', estado: '', rg: 0,
                email: '', fstatus: 0});
  }
}
