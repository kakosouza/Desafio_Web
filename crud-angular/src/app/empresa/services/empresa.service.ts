import { Injectable } from '@angular/core';

import { Empresa } from 'src/app/shared/models/empresa.model';

const LS_CHAVE: string = "empresas";

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor() { }

  listarTodos(): Empresa[] {
    const empresas = localStorage[LS_CHAVE];
    return empresas ? JSON.parse(empresas) : [];
  }

  inserir(empresa: Empresa): void {
    //Obtem a lista completa de fornecedores
    const empresas = this.listarTodos();

    empresa.id = new Date().getTime();

    //Adiciona no final da lista
    empresas.push(empresa);

    //Armazena local storage
    localStorage[LS_CHAVE] = JSON.stringify(empresas);
  }

  buscarPorId(cnpj: string): Empresa | undefined {
    const empresas: Empresa[] = this.listarTodos();
    //Faz a busca por chave
    return empresas.find(empresa => empresa.cnpj == cnpj);
  }

  atualizar(empresa: Empresa): void {
    //Obtem a lista completa de fornecedores
    const empresas = this.listarTodos();

    empresas.forEach((obj, index, objs) => {
      if (empresa.id === obj.id) {
        objs[index] = empresa
      }
    });

    //Armazena
    localStorage[LS_CHAVE] = JSON.stringify(empresas);
  }

  remover(cnpj: string): void {
    let empresas: Empresa[] = this.listarTodos();

    empresas = empresas.filter(empresa => empresa.cnpj !== cnpj);

    //Armazena
    localStorage[LS_CHAVE] = JSON.stringify(empresas);
  }
}
