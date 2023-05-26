import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';
import { Fornecedor } from 'src/shared/models/fornecedor.model';
import { ConsultaCepService } from 'src/shared/services/consulta-cep.service';

import { FornecedoresService } from '../services/fornecedores.service';

@Component({
  selector: 'app-fornecedor-inserir',
  templateUrl: './fornecedor-inserir.component.html',
  styleUrls: ['./fornecedor-inserir.component.scss']
})
export class FornecedorInserirComponent implements OnInit {

  private dataIni: Date = new Date();

  form = this.formBuilder.group({
    chave: [''],
    nome: [''],
    cep: [''],
    logradouro: [''],
    numero: [0],
    complemento: [''],
    bairro: [''],
    cidade: [''],
    estado: [''],
    rg: [0],
    email: [''],
    dtnascimento: [this.dataIni],
    fstatus: [0]
  });

  public cepInput: string = '';
  public chaveInput: string = '';
  public dados = new XMLHttpRequest();
  private fornecedor: Fornecedor = new  Fornecedor;

  constructor(private formBuilder: FormBuilder,
      private service: FornecedoresService,
      private snackBar: MatSnackBar,
      private dialog: MatDialog,
      private location: Location,
      private cepService: ConsultaCepService,
      private route: ActivatedRoute
      ) { }


  ngOnInit() {
  }


  onSubmit() {
      this.service.save(this.form.value as Fornecedor)
      .subscribe(next => this.onSuccess(), error => this.onError()
      );
    this.form.reset();
  }

  onCancel(): void {
      this.location.back();
  }

  onCnpj() {
    if (this.chaveInput != null && this.chaveInput !== '') {
      this.service.loadByChave(this.cepInput)
           .subscribe(item => this.fornecedor = item)

      console.log('ChaveValor');
      console.log(this.fornecedor.chave);
      if (this.form.value.chave === this.fornecedor.chave) {
        this.snackBar.open('CNPJ já cadastrado.', '', {duration: 5000});
        this.form.value.chave = '';
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
      chave: this.form.value.chave,
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
    this.snackBar.open('Fornecedor salvo com sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  onError() {
    this.dialog.open(ErrorDialogComponent, {
     data: 'Erro ao salvar Fornecedor.'});
  }

  getErrorMessage(fieldName: string) {
    const field = this.form.get(fieldName);

    if (field?.hasError('required')) {
        return 'Campo Obrigatório';
    }

    if (fieldName === "chave") {
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

