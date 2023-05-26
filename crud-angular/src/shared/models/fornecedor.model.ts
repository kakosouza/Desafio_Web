export class Fornecedor {
  constructor(
      public id?: number,
      public chave?: string,
      public nome?: string,
      public cep?: string,
      public logradouro?: string,
      public numero?: number,
      public complemento?: string,
      public bairro?: string,
      public cidade?: string,
      public estado?: string,
      public rg?: number,
      public email?: string,
      public dtnascimento?: Date,
      public fstatus?: number
  ) {}
}
