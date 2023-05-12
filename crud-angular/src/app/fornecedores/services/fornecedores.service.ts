import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
import { Fornecedor } from 'src/shared/models/fornecedor.model';

@Injectable({
  providedIn: 'root'
})
export class FornecedoresService {

  private readonly API = 'api/fornecedores';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Fornecedor[]>(this.API)
      .pipe(
        first(),
      );
  }

  loadById(id: number) {
    return this.httpClient.get<Fornecedor>(`${this.API}/${id}`);

  }

  save(record: Partial<Fornecedor>) {
    console.log(record);
    if (record.id) {
      console.log('Update')
      return this.update(record);
    }
      console.log('Create')
      return this.create(record);
  }

  private create(record: Partial<Fornecedor>) {
    return this.httpClient.post<Fornecedor>(this.API, record).pipe(first());
  }

  private update(record: Partial<Fornecedor>) {
    return this.httpClient.put<Fornecedor>(`${this.API}/${record.id}`, record).pipe(first());
  }

  remove(id: number) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
