import { Component, OnInit } from '@angular/core';
import { Empresa } from 'src/app/shared/models/empresa.model';

import { EmpresaService } from './../services/empresa.service';

@Component({
  selector: 'app-listar-empresa',
  templateUrl: './listar-empresa.component.html',
  styleUrls: ['./listar-empresa.component.scss']
})
export class ListarEmpresaComponent implements OnInit {

  empresas : Empresa[] = [];

  constructor(private empresaService: EmpresaService) {}

  ngOnInit(): void {
    this.empresas = this.listarTodos();
  }

  listarTodos(): Empresa[] {
    return this.empresaService.listarTodos();
  }
}
