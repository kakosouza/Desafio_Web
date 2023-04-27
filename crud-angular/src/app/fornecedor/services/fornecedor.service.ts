import { Injectable } from '@angular/core';

import { Fornecedor } from 'src/app/shared/models/fornecedor.model';

const LS_CHAVE: string = "fornecedores";

@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor() { }

  listarTodos(): Fornecedor[] {
    const fornecedores = localStorage[LS_CHAVE];
    return fornecedores ? JSON.parse(fornecedores) : [];
  }

  inserir(fornecedor: Fornecedor): void {
    //Obtem a lista completa de fornecedores
    const fornecedores = this.listarTodos();

    fornecedor.id = new Date().getTime();

    //Adiciona no final da lista
    fornecedores.push(fornecedor);

    //Armazena local storage
    localStorage[LS_CHAVE] = JSON.stringify(fornecedores);
  }

  buscarPorId(id: number): Fornecedor | undefined {
    const fornecedores: Fornecedor[] = this.listarTodos();
    //Faz a busca por chave
    return fornecedores.find(fornecedor => fornecedor.id === id);
  }

  atualizar(fornecedor: Fornecedor): void {
    //Obtem a lista completa de fornecedores
    const fornecedores: Fornecedor[] = this.listarTodos();

    fornecedores.forEach((obj, index, objs) => {
      if (fornecedor.id === obj.id) {
        objs[index] = fornecedor;
      }
    });

    //Armazena
    localStorage[LS_CHAVE] = JSON.stringify(fornecedores);
  }

  remover(id: number): void {
    let fornecedores: Fornecedor[] = this.listarTodos();

    fornecedores = fornecedores.filter(fornecedor => fornecedor.id !== id);

    //Armazena
    localStorage[LS_CHAVE] = JSON.stringify(fornecedores);
  }
}
