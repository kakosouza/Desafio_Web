import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Fornecedor } from 'src/shared/models/fornecedor.model';

@Component({
  selector: 'app-fornecedores-list',
  templateUrl: './fornecedores-list.component.html',
  styleUrls: ['./fornecedores-list.component.scss']
})
export class FornecedoresListComponent implements OnInit{

  @Input() fornecedores: Fornecedor[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['chave','nome','actions'];

  constructor() { }

  ngOnInit(): void {
  }

  onAdd() {
    this.add.emit(true);
  }

  onEdit(fornecedor: Fornecedor) {
    this.edit.emit(fornecedor);
  }

  onDelete(fornecedor: Fornecedor): void {
    this.remove.emit(fornecedor);
  }
}
