import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Empresa } from 'src/shared/models/empresa.model';


export interface Resolve<Empresa> {
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Empresa>
  |Promise<Empresa>|Empresa
  }
