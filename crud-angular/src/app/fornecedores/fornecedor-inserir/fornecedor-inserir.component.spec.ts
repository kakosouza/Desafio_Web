import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FornecedorInserirComponent } from './fornecedor-inserir.component';

describe('FornecedorInserirComponent', () => {
  let component: FornecedorInserirComponent;
  let fixture: ComponentFixture<FornecedorInserirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FornecedorInserirComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FornecedorInserirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
