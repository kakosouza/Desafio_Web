import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresaInserirComponent } from './empresa-inserir.component';

describe('EmpresaInserirComponent', () => {
  let component: EmpresaInserirComponent;
  let fixture: ComponentFixture<EmpresaInserirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpresaInserirComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpresaInserirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
