import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap, delay } from 'rxjs/operators';
import { Empresa } from 'src/app/shared/models/empresa.model';

const LS_CHAVE: string = "empresas";

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private readonly API = '/assets/empresas.json';

  constructor(private httpClient: HttpClient) { }

//  listarTodos(): Empresa[] {
  listarTodos() {
      return this.httpClient.get<Empresa[]>(this.API)
      .pipe(
        first(),
//        delay(5000),
        tap(empresas => console.log(empresas))
      );
  }

  inserir(record: Partial<Empresa>) {
    return this.httpClient.post<Empresa>(this.API, record).pipe(first());
  }

//  buscarPorId(id: number): Empresa | undefined {
  buscarPorId(id: number) {
      return this.httpClient.get<Empresa>('${this.API}/${id}');
  }

  atualizar(record: Partial<Empresa>) {
    return this.httpClient.put<Empresa>(`${this.API}/${record.id}`, record).pipe(first());
  }

  salvar(record: Partial<Empresa>) {
    // console.log(record);
    if (record.id) {
      // console.log('update');
      return this.atualizar(record);
    }
    // console.log('create');
    return this.inserir(record);
  }

  remover(id: number) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
