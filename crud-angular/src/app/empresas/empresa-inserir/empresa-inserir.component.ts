import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { EmpresasService } from '../services/empresas.service';

@Component({
  selector: 'app-empresa-inserir',
  templateUrl: './empresa-inserir.component.html',
  styleUrls: ['./empresa-inserir.component.scss']
})
export class EmpresaInserirComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
      private service: EmpresasService,
      private snackBar: MatSnackBar,
      private location: Location
    ) {
    this.form = this.formBuilder.group({
      cnpj: [null],
      nome: [null],
      logradouro: [null],
      numero: [null],
      complemento: [null],
      bairro: [null],
      cidade: [null],
      estado: [null],
      cep: [null]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(data => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  onCep() {

  }

  onSuccess() {
    this.snackBar.open('Empresa salva com sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  onError() {
    this.snackBar.open('Erro ao salvar Empresa.', '', {duration: 5000});
  }
}
