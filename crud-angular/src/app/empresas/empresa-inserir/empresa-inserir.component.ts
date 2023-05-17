import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { EmpresasService } from '../services/empresas.service';
import { Location } from '@angular/common';
import { ConsultaCepService } from 'src/shared/services/consulta-cep.service';

@Component({
  selector: 'app-empresa-inserir',
  templateUrl: './empresa-inserir.component.html',
  styleUrls: ['./empresa-inserir.component.scss']
})
export class EmpresaInserirComponent implements OnInit {

//  form: FormGroup;
  public cepInput: string = '';
  public dados = new XMLHttpRequest();

  form = this.formBuilder.group({
    id: [0],
    cnpj: ['', [Validators.required,
                Validators.minLength(14),
                Validators.maxLength(14)]],
    nome: ['', [Validators.required,
                Validators.minLength(5),
                Validators.maxLength(200)]],
    logradouro: [''],
    numero: [0],
    complemento: [''],
    bairro: [''],
    cidade: [''],
    estado: ['', [Validators.minLength(2),
                 Validators.maxLength(2)]],
    cep: ['']
  });

  constructor(private formBuilder: NonNullableFormBuilder,
      private service: EmpresasService,
      private snackBar: MatSnackBar,
      private location: Location,
      private route: ActivatedRoute,
      private cepService: ConsultaCepService,
      private rotaAtiva: ActivatedRoute
      ) {
//      this.
  }

  ngOnInit() {
/*    const empresa: Empresa = this.route.snapshot.data['empresa'];
    this.form.setValue({
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
    });*/
   }

  onSubmit() {
    if (this.form.valid !== null) {
      console.log(this.form.value);
      this.service.save(this.form.value).subscribe(data => {
        this.onSuccess();
        this.form.reset();
      });
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
    this.snackBar.open('Erro ao salvar Empresa.', '', {duration: 5000});
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
