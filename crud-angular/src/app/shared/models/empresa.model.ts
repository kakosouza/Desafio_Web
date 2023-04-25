export class Empresa {
  constructor(
    public id?: number,
    public cnpj?: string,
    public nome_fantasia?: string,
    public logradouro?: string,
    public numero?: number,
    public complemento?: string,
    public bairro?: string,
    public cidade?: string,
    public estado?: string,
    public cep?: string) {
  }

}
