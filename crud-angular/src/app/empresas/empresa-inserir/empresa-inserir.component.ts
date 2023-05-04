import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-empresa-inserir',
  templateUrl: './empresa-inserir.component.html',
  styleUrls: ['./empresa-inserir.component.scss']
})
export class EmpresaInserirComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      cnpj: [null],
      nome: [null],
      logradouro: [null],
      numero: [0],
      complemento: [null],
      bairro: [null],
      cidade: [null],
      estado: [null],
      cep: [null]
    });
  }

  ngOnInit(): void {
  }
}
