import { TestBed } from '@angular/core/testing';

import { FornecedorResolver } from '../../fornecedores/guards/fornecedor.resolver';

describe('FornecedorResolver', () => {
  let resolver: FornecedorResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(FornecedorResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
