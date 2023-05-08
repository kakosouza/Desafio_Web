import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { EmpresasService } from '../services/empresas.service';

@Component({
  selector: 'app-empresa-editar',
  templateUrl: './empresa-editar.component.html',
  styleUrls: ['./empresa-editar.component.scss']
})
export class EmpresaEditarComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
      private service: EmpresasService,
      private snackBar: MatSnackBar,
      private location: Location
    ) {
    this.form = this.formBuilder.group({
      cnpj: [''],
      nome: [''],
      logradouro: [''],
      numero: [0],
      complemento: [''],
      bairro: [''],
      cidade: [''],
      estado: [''],
      cep: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.form.valid) {
      this.service.save(this.form.value).subscribe(data => this.onSuccess());
    }
    else  {
      this.service.save(this.form.value).subscribe(error => this.onError());
    }
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
