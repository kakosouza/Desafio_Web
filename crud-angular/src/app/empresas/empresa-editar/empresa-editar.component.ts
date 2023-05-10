import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

import { EmpresasService } from '../services/empresas.service';
import { Empresa } from 'src/shared/models/empresa.model';

@Component({
  selector: 'app-empresa-editar',
  templateUrl: './empresa-editar.component.html',
  styleUrls: ['./empresa-editar.component.scss']
})
export class EmpresaEditarComponent implements OnInit {

  formEdit: FormGroup;

  constructor(private formBuilder: FormBuilder,
      private service: EmpresasService,
      private snackBar: MatSnackBar,
      private location: Location,
      private route: ActivatedRoute,
      private router: Router
    ) {
      this.formEdit = this.formBuilder.group({
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

  ngOnInit(): void {
    const empresa: Empresa = this.route.snapshot.data['empresa'];
    this.formEdit.setValue({
      id: empresa.id,
      cnpj: empresa.cnpj,
      nome: empresa.nome,
      cep: empresa.cep,
      logradouro: empresa.logradouro,
      numero: empresa.numero,
      complemento: empresa.complemento,
      bairro: empresa.bairro,
      cidade: empresa.cidade,
      estado: empresa.estado
    });
  }

  onSubmit() {
    if (this.formEdit.valid !== null) {
      this.service.save(this.formEdit.value).subscribe(data => this.onSuccess());
    }
    else  {
      this.service.save(this.formEdit.value).subscribe(error => this.onError());
    }
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
