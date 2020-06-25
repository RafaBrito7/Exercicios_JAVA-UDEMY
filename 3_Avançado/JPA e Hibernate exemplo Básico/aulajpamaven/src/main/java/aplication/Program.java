package aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;


public class Program {

	public static void main(String[] args) {
		// Sempre que houver uma a��o que n�o seja uma simples consulta ao DB, � necess�rio uma transaction

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
