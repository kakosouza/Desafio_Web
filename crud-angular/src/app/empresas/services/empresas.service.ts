import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap, first } from 'rxjs';
import { Empresa } from 'src/shared/models/empresa.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private readonly API = 'api/empresas';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Empresa[]>(this.API)
      .pipe(
        first(),
//        delay(5000),
        tap(empresas => console.log(empresas))
      );
  }

  save(record: Empresa) {
    return this.httpClient.post<Empresa>(this.API, record);
  }
}
