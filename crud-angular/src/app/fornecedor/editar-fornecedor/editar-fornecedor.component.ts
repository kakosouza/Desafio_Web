import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Fornecedor } from 'src/app/shared/models/fornecedor.model';

import { FornecedorService } from './../services/fornecedor.service';

@Component({
  selector: 'app-editar-fornecedor',
  templateUrl: './editar-fornecedor.component.html',
  styleUrls: ['./editar-fornecedor.component.scss']
})
export class EditarFornecedorComponent implements OnInit {
  //Ligando o formulário
  @ViewChild('formFornecedor') formFornecedor! : NgForm;
  fornecedor! : Fornecedor;

  constructor(
    private fornecedorService: FornecedorService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    //O + converte o parâmetro para número
    let id = +this.route.snapshot.params['id'];

    const res = this.fornecedorService.buscarPorId(id);
    if (res !== undefined)
        this.fornecedor = res;
    else
        throw new Error ("Fornecedor não encontrado: id = " + id);
  }

  //Método Atualizar
  atualizar(): void {
    if (this.formFornecedor.form.valid) {
      this.fornecedorService.atualizar(this.fornecedor);
      this.router.navigate( ["/fornecedores"] );
    }
  }
}
