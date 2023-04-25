import { Component, OnInit } from '@angular/core';
import { Fornecedor } from 'src/app/shared/models/fornecedor.model';

import { FornecedorService } from './../services/fornecedor.service';

@Component({
  selector: 'app-listar-fornecedor',
  templateUrl: './listar-fornecedor.component.html',
  styleUrls: ['./listar-fornecedor.component.scss']
})
export class ListarFornecedorComponent implements OnInit {

  fornecedores: Fornecedor[] = [];

  constructor(private fornecedorService : FornecedorService) {}

  ngOnInit(): void {
    this.fornecedores = this.listaTodos();
  }

  listaTodos(): Fornecedor[] {
//    return this.fornecedorService.listarTodos();
      return [
        new Fornecedor(1, "00011111111111", "Antonio"),
        new Fornecedor(1, "00022222222222", "Carlos"),
        new Fornecedor(1, "11111111111111", "Sandra"),
        new Fornecedor(1, "00033333333333", "Paulo")
      ];
  }
}
