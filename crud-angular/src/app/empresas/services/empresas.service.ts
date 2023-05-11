import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
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
//        tap(empresas => console.log(empresas))
      );
  }

  loadById(id: number) {
    return this.httpClient.get<Empresa>(`${this.API}/${id}`);

  }

  save(record: Partial<Empresa>) {
    console.log(record);
    if (record.id) {
      return this.update(record);
    }
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

  buscar(cep: string, dados: XMLHttpRequest) {
//    console.log(cep);
    alert(cep);
    dados.open("GET", "http://cep.la/" + cep + '"', true);
    dados.setRequestHeader ("Accept", "application/json");
    dados.onreadystatechange = function() {
      if ((this.readyState === 0 || this.readyState === 4 ) && this.status === 200)
        alert(this.responseText)
//        return this.responseText;
    };
    dados.send(null);
  }
}
