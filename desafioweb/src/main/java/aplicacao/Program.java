package aplicacao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Empresa;
import dominio.Fornecedor;

public class Program {

	public static void main(String[] args) {

		Empresa e1 = new Empresa("33333333333333", "EMPRESA TESTE", "50000000", "AV AGAMENON MAGALHAES", 1200, "EDF. SAMPA", "RECIFE", "DERBY", "PE");
		
//		Fornecedor f1 = new Fornecedor("00011111111111", "CARLOS SOUZA", 99999999, "1964-07-02", "fulano@gamil.com", "50000000", "AV MASCARENHAS DE MORAIS", 2000, "SALA 1", "RECIFE", "IMBIRIBEIRA", "PE");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafio");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
		System.out.println("Pronto!");
	}

}
