import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empresa } from 'src/shared/models/empresa.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  constructor(private httpClient: HttpClient) { }

  list(): Empresa[] {
    return [
      {id: 1, cnpj: '11111111111111', nome: 'ACCENTURE'}
    ];
  }
}
