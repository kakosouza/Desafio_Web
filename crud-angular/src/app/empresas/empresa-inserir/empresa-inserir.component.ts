import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

import { EmpresasService } from '../services/empresas.service';
import { Location } from '@angular/common';

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
      private location: Location,
      private route: ActivatedRoute,
      private router: Router
    ) {
      this.form = this.formBuilder.group({
        id: [0],
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

  ngOnInit() { }

  onSubmit() {
    if (this.form.valid !== null) {
      this.service.save(this.form.value).subscribe(data => this.onSuccess());
    }
    else  {
      this.service.save(this.form.value).subscribe(error => this.onError());
    }
    this.form.reset();
  }

  onCancel(): void {
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
