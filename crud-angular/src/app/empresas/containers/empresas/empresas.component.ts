import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ConfirmationDialogComponent } from 'src/shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';
import { Empresa } from 'src/shared/models/empresa.model';

import { EmpresasService } from '../../services/empresas.service';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.scss']
})
export class EmpresasComponent implements OnInit {

  empresas$: Observable<Empresa[]> | null = null;

  readonly displayedColumns = ['cnpj','nome','actions'];


  constructor(
    private empresaService: EmpresasService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh() {
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

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

  onEdit(empresa: Empresa) {
    this.router.navigate(['edit', empresa.id], {relativeTo: this.route});
  }

  onRemove(empresa: Empresa) {
    const ident: number = empresa.id as number;
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse curso?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {

          this.empresaService.remove(ident).subscribe(
            () => {
              this.refresh();
              this.snackBar.open('Empresa removida com sucesso!', 'X', {
                duration: 5000,
                verticalPosition: 'top',
                horizontalPosition: 'center'
              })
            },
            error => this.onError('Erro ao tentar remover a Empresa.')
            );
          }
      });
  }
}

