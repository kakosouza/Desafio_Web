import { EmpresaService } from './../services/empresa.service';
import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, catchError, of } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Empresa } from 'src/app/shared/models/empresa.model';

@Component({
  selector: 'app-listar-empresa',
  templateUrl: './listar-empresa.component.html',
  styleUrls: ['./listar-empresa.component.scss']
})
export class ListarEmpresaComponent implements OnInit {

//  @Input() empresas: Empresa[] = [];
  empresas$: Observable<Empresa[]>;
  @Output() inserir = new EventEmitter(false);
  @Output() atualizar = new EventEmitter(false);
  @Output() remover = new EventEmitter(false);

  readonly displayedColumns = ['cnpj', 'nome'];

  constructor(
    private empresaService: EmpresaService,
    public dialog: MatDialog
    ) {
    this.empresas$ = this.empresaService.listarTodos()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar a Lista de Empresas.');
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
    this.inserir.emit(true);
  }

  onEdit(empresa: Empresa) {
    this.atualizar.emit(empresa);
  }

  onDelete(empresa: Empresa) {
    this.remover.emit(empresa);
  }
}
