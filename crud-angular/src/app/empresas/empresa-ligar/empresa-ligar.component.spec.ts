import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpresaLigarComponent } from './empresa-ligar.component';

describe('EmpresaLigarComponent', () => {
  let component: EmpresaLigarComponent;
  let fixture: ComponentFixture<EmpresaLigarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpresaLigarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpresaLigarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
