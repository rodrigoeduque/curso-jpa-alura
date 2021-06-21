package br.com.rodrigoeduque.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		
		Conta conta = new Conta();
		
		conta.setTitular("Rodrigo Eustáquio Duque");
		conta.setAgencia(1234);
		conta.setNumero(1122334);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
	}
}
