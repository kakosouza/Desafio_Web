import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';
import { Empresa } from 'src/shared/models/empresa.model';

import { EmpresasService } from '../services/empresas.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.scss']
})
export class EmpresasComponent implements OnInit {

  empresas$: Observable<Empresa[]>;

  readonly displayedColumns = ['cnpj','nome','actions'];


  constructor(
    private empresaService: EmpresasService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute

  ) {
    this.empresas$ = this.empresaService.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar empresas.');
          return of([])
        })
      );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }
}
