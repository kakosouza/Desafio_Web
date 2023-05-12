import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

export interface Resolve<Fornecedor> {
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Fornecedor>
  |Promise<Fornecedor>|Fornecedor
  }
