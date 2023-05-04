import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap, first, delay } from 'rxjs';
import { Empresa } from 'src/shared/models/empresa.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private readonly API = '/assets/empresas.json';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Empresa[]>(this.API)
      .pipe(
        first(),
        delay(5000),
        tap(empresas => console.log(empresas))
      );
  }
}
