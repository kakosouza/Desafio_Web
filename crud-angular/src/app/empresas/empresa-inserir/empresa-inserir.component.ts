import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';
import { Empresa } from 'src/shared/models/empresa.model';
import { ConsultaCepService } from 'src/shared/services/consulta-cep.service';

import { EmpresasService } from '../services/empresas.service';

@Component({
  selector: 'app-empresa-inserir',
  templateUrl: './empresa-inserir.component.html',
  styleUrls: ['./empresa-inserir.component.scss']
})
export class EmpresaInserirComponent implements OnInit {

  form = this.formBuilder.group({
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
  }


  onSubmit() {
      this.service.save(this.form.value as Empresa)
      .subscribe(next => this.onSuccess(), error => this.onError()
      );
    this.form.reset();
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
      if (this.form.value.cnpj === this.empresa.cnpj) {
        this.snackBar.open('CNPJ já cadastrado.', '', {duration: 5000});
        this.form.value.cnpj = '';
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
    this.form.patchValue({
      cnpj: this.form.value.cnpj,
      nome: this.form.value.nome,
      logradouro: dados.logradouro,
      numero: this.form.value.numero,
      complemento: this.form.value.complemento,
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

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
        return 'Campo Obrigatório';
    }

    if (fieldName === "cnpj") {
      if (isNaN(field?.value)) {
        return `Este campo precisa ser numérico.`
      }

      if (field?.hasError('minlength')) {
          const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 14;
          return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
      }

      if (field?.hasError('maxlength')) {
          const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 14;
          return `Tamanho máximo excedido de ${requiredLength} caracteres.`;
      }
    }

    if (fieldName === "nome" && field?.hasError('minlength')) {
      const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
    }

    if (fieldName === "numero") {
      if (isNaN(field?.value)) {
          return `Este campo precisa ser numérico.`
      }

      if (field?.hasError('minlength')) {
        const requiredLength: number = field.errors ? field.errors['minlength']['requiredLength'] : 1;
        return `Tamanho mínimo precisa ser de ${requiredLength} caracteres.`;
      }

      if (field?.hasError('maxlength')) {
        const requiredLength: number = field.errors ? field.errors['maxlength']['requiredLength'] : 5;
        return `Tamanho máximo excedido de ${requiredLength} caracteres.`;
      }

    }
    return 'Campo Inválido';
  }
}
