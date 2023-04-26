export class Fornecedor {
  constructor(
      public id?: number,
      public chave?: string,
      public nome?: string,
      public logradouro?: string,
      public numero?: number,
      public complemento?: string,
      public bairro?: string,
      public cidade?: string,
      public estado?: string,
      public cep?: string,
      public dt_nascimento?: Date,
      public email?: string,
      public fstatus?: number,
      public rg?: number
  ) {}
}
