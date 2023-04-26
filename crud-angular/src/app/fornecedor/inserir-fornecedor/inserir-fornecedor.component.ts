import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Fornecedor } from 'src/app/shared/models/fornecedor.model';

import { FornecedorService } from './../services/fornecedor.service';

@Component({
  selector: 'app-inserir-fornecedor',
  templateUrl: './inserir-fornecedor.component.html',
  styleUrls: ['./inserir-fornecedor.component.scss']
})
export class InserirFornecedorComponent implements OnInit {
  //Ligando o formulário
  @ViewChild('formFornecedor') formFornecedor! : NgForm;
  fornecedor! : Fornecedor;

  constructor(
    private fornecedorService: FornecedorService,
    private router: Router) { }

  ngOnInit(): void {
    this.fornecedor = new Fornecedor();
  }

  //Método Inserir
  inserir(): void {
      if (this.formFornecedor.form.valid) {
        this.fornecedorService.inserir(this.fornecedor);
        this.router.navigate( ["/fornecedores"] );
      }
  }
}
