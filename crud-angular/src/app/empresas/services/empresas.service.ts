import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { Empresa } from 'src/shared/models/empresa.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private readonly API = 'api/empresas';


  constructor(private httpClient: HttpClient,
      private router: Router
    ) { }

  list() {
    return this.httpClient.get<Empresa[]>(this.API)
      .pipe(
        first(),
//        delay(5000),
//        tap(empresas => console.log(empresas))
      );
  }

  loadByCnpj(cnpj: string) {
    return this.httpClient.get<Empresa>(`${this.API}/${cnpj}`);
  }

  loadById(id: number) {
    return this.httpClient.get<Empresa>(`${this.API}/${id}`);

  }

  save(record: Partial<Empresa>) {
//    return this.httpClient.post<Empresa>(this.API, record).pipe(first());
    console.log(record);
    if (record.id) {
      console.log('Update')
      return this.update(record);
    }
      console.log('Create')
      return this.create(record);
  }

  private create(record: Partial<Empresa>) {
      return this.httpClient.post<Empresa>(this.API, record).pipe(first());
  }

  private update(record: Partial<Empresa>) {
    return this.httpClient.put<Empresa>(`${this.API}/${record.id}`, record).pipe(first());
  }

  remove(id: number) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
