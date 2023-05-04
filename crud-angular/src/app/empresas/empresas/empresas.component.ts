import { Component, OnInit } from '@angular/core';
import { Empresa } from 'src/shared/models/empresa.model';
import { EmpresasService } from '../services/empresas.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.scss']
})
export class EmpresasComponent implements OnInit {

  empresas$: Observable<Empresa[]>;

  displayedColumns = ['cnpj','nome','actions'];


  constructor(private empresaService: EmpresasService) {
    this.empresas$ = this.empresaService.list();
  }

  ngOnInit(): void {
  }
}
