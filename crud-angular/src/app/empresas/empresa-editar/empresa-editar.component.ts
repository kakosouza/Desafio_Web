import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Empresa } from 'src/shared/models/empresa.model';
import { ConsultaCepService } from 'src/shared/services/consulta-cep.service';

import { EmpresasService } from '../services/empresas.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-empresa-editar',
  templateUrl: './empresa-editar.component.html',
  styleUrls: ['./empresa-editar.component.scss']
})
export class EmpresaEditarComponent implements OnInit {
  formEdit = this.formBuilder.group({
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

  public cepInput: string = '';
  public cnpjInput: string = '';
  public dados = new XMLHttpRequest();
  private empresa: Empresa = new  Empresa;

  constructor(private formBuilder: FormBuilder,
      private service: EmpresasService,
      private snackBar: MatSnackBar,
      private dialog: MatDialog,
      private location: Location,
      private cepService: ConsultaCepService,
      private route: ActivatedRoute
      ) { }


  ngOnInit() {
    const empresa: Empresa = this.route.snapshot.data['empresa'];
    this.formEdit.patchValue({
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
      this.service.save(this.formEdit.value as Empresa)
      .subscribe(next => this.onSuccess(), error => this.onError()
      );
    this.formEdit.reset();
  }

  onCancel(): void {
      this.location.back();
  }

  onCnpj() {
    if (this.cnpjInput != null && this.cnpjInput !== '') {
      this.service.loadByCnpj(this.cepInput)
           .subscribe(item => this.empresa = item)

      console.log('CnpjValor');
      console.log(this.empresa.cnpj);
      if (this.formEdit.value.cnpj === this.empresa.cnpj) {
        this.snackBar.open('CNPJ já cadastrado.', '', {duration: 5000});
        this.formEdit.value.cnpj = '';
      }
    }
  }

  onCep() {
    if (this.cepInput != null && this.cepInput !== ''){
        this.cepService.buscarCep(this.cepInput)
        ?.subscribe(dados => this.populaDadosForm(dados));
      }
  }

  populaDadosForm(dados:any) {
    this.formEdit.patchValue({
      cnpj: this.formEdit.value.cnpj,
      nome: this.formEdit.value.nome,
      logradouro: dados.logradouro,
      numero: this.formEdit.value.numero,
      complemento: this.formEdit.value.complemento,
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf,
      cep: dados.cep
      });
  }

  onSuccess() {
    this.snackBar.open('Empresa salva com sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  onError() {
    this.dialog.open(ErrorDialogComponent, {
     data: 'Erro ao salvar Empresa.'});
  }
}
