import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Empresa } from 'src/shared/models/empresa.model';

@Component({
  selector: 'app-empresas-list',
  templateUrl: './empresas-list.component.html',
  styleUrls: ['./empresas-list.component.scss']
})
export class EmpresasListComponent implements OnInit{

  @Input() empresas: Empresa[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['cnpj','nome','actions'];

  constructor() { }

  ngOnInit(): void {
  }

  onAdd() {
    this.add.emit(true);
  }

  onEdit(empresa: Empresa) {
    this.edit.emit(empresa);
  }

  onDelete(empresa: Empresa): void {
    this.remove.emit(empresa);
  }
}
