package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Empresa;

public class Program {

	public static void main(String[] args) {

		Empresa e1 = new Empresa("33333333333333", "EMPRESA TESTE", "50000000", "AV AGAMENON MAGALHAES", 1200, "EDF. SAMPA", "RECIFE", "DERBY", "PE");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafio");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
		System.out.println("Pronto!");
	}

}
