package br.com.rodrigoeduque.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Conta;

public class AlteraSaldoContaRodrigo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		
		Conta contaRodrigo = em.find(Conta.class, 1L);
		
		System.out.println(contaRodrigo.getTitular());
		
		em.getTransaction().begin();
		contaRodrigo.setSaldo(300.00);
		em.getTransaction().commit();
		
	}
}
