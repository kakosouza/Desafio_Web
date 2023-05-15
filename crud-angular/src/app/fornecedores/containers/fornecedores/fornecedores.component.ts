import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ConfirmationDialogComponent } from 'src/shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from 'src/shared/components/error-dialog/error-dialog.component';

import { FornecedoresService } from '../../services/fornecedores.service';
import { Fornecedor } from 'src/shared/models/fornecedor.model';


@Component({
  selector: 'app-fornecedores',
  templateUrl: './fornecedores.component.html',
  styleUrls: ['./fornecedores.component.scss']
})
export class FornecedoresComponent implements OnInit {

  fornecedores$: Observable<Fornecedor[]> | null = null;

  readonly displayedColumns = ['chave','nome','actions'];


  constructor(
    private fornecedorService: FornecedoresService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
    this.refresh();
  }

  refresh() {
    this.fornecedores$ = this.fornecedorService.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar fornecedores.');
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

  onEdit(fornecedor: Fornecedor) {
    this.router.navigate(['edit', fornecedor.id], {relativeTo: this.route });
  }

  onRemove(fornecedor: Fornecedor) {
    const ident: number = fornecedor.id as number;
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse fornecedor?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {

          this.fornecedorService.remove(ident).subscribe(
            () => {
              this.refresh();
              this.snackBar.open('Fornecedorsa removido com sucesso!', 'X', {
                duration: 5000,
                verticalPosition: 'top',
                horizontalPosition: 'center'
              })
            },
            error => this.onError('Erro ao tentar remover o Fornecedor.')
            );
          }
      });
  }
}


