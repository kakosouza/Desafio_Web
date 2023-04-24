import { Component, OnInit } from '@angular/core';
import { Fornecedor } from '../model/fornecedor';

@Component({
  selector: 'app-cadastros',
  templateUrl: './cadastros.component.html',
  styleUrls: ['./cadastros.component.scss']
})
export class CadastrosComponent implements OnInit {

  // Inicializando o array
  cadastros: Fornecedor[] = [];
  displayedColumns = ['chave','nome','logradouro','complemento','bairro','cidade','estado','cep','email'];

  constructor() {
  }

  ngOnInit(): void {
  }
}
