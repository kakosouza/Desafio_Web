import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsultaCepService {

  constructor(
    private http: HttpClient
  ) { }


  buscarCep(cep: string) {
        //Verifica se só tem dígitos
        cep = cep.replace(/\D/g, '');

        if (cep !== '') {
           //Expressão regular para validar CEP
           const validacep = /^[0-9]{8}$/;

           //Valida formato do CEP
           if (validacep.test(cep)) {
              return this.http.get(`//viacep.com.br/ws/${cep}/json`);
           }
           alert(cep);
        }
        alert('Vazio');
        return of({});
  }
}
