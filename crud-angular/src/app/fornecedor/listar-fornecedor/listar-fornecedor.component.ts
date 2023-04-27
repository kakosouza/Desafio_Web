import { Component, OnInit } from '@angular/core';
import { Fornecedor } from 'src/app/shared/models/fornecedor.model';

import { FornecedorService } from './../services/fornecedor.service';

@Component({
  selector: 'app-listar-fornecedor',
  templateUrl: './listar-fornecedor.component.html',
  styleUrls: ['./listar-fornecedor.component.scss']
})
export class ListarFornecedorComponent implements OnInit {

  fornecedores : Fornecedor[] = [];

  constructor(private fornecedorService: FornecedorService) {}

  ngOnInit(): void {
    this.fornecedores = this.listaTodos();
  }

  listaTodos(): Fornecedor[] {
    return this.fornecedorService.listarTodos();
  }

  remover($event: any, fornecedor: Fornecedor): void {
    $event.preventDefault();
    if (confirm('Deseja realmente remover o fornecedor?')) {
       this.fornecedorService.remover(fornecedor.id!);
       this.fornecedores = this.listaTodos();
    }
  }

}
