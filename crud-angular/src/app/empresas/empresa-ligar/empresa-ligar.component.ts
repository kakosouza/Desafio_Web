import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';
import { Empresa } from 'src/shared/models/empresa.model';

import { EmpresasService } from '../services/empresas.service';
import { Fornecedor } from 'src/shared/models/fornecedor.model';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { FornecedoresService } from 'src/app/fornecedores/services/fornecedores.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-empresa-ligar',
  templateUrl: './empresa-ligar.component.html',
  styleUrls: ['./empresa-ligar.component.scss']
})
export class EmpresaLigarComponent implements OnInit {

  fornecedores$!: Observable<Fornecedor[]>;
  displayedColumns: string[] = ['select','chave','nome'];
  dataSource = new MatTableDataSource<Fornecedor>();
  selection = new SelectionModel<Fornecedor>(true, []);
  servicef: FornecedoresService;


  formLiga = this.formBuilder.group({
    id: [0],
    cnpj: [''],
    nome: ['']
  });

  constructor(private formBuilder: FormBuilder,
    private service: EmpresasService,
    private snackBar: MatSnackBar,
    private dialog: MatDialog,
    private location: Location,
    private route: ActivatedRoute,
    private httpClient: HttpClient,
    private router: Router
    ) {
      this.servicef = new FornecedoresService(this.httpClient, this.router);
      this.fornecedores$ = this.servicef.list();
    }

  ngOnInit() {
    const empresa: Empresa = this.route.snapshot.data['empresa'];
    this.formLiga.patchValue({
      id: empresa.id,
      cnpj: empresa.cnpj,
      nome: empresa.nome
    });
  }

/*  refresh() {
    this.fornecedores = this.servicef.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar fornecedores.');
          return of([])
        })
      );
  }*/


  onSubmit() {
    this.service.save(this.formLiga.value as Empresa)
    .subscribe(next => this.onSuccess(), error => this.onError()
    );
    this.formLiga.reset();
  }

  onCancel(): void {
    this.location.back();
  }

  onSuccess() {
    this.snackBar.open('Empresa salva com sucesso!', '', {duration: 5000});
    this.onCancel();
  }

  onError() {
    this.dialog.open(ErrorDialogComponent, {
     data: 'Erro ao salvar Empresa.'});
  }

  masterToggle() {
    // if there is a selection then clear that selection
//    if (this.isSomeSelected()) {
//      this.selection.clear();
//    } else {
      this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
//    }
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }
}
