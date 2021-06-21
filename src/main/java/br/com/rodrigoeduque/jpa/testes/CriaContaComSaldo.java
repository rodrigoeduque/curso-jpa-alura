package br.com.rodrigoeduque.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Conta;

public class CriaContaComSaldo {
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		
		Conta conta = new Conta();
		
		conta.setTitular("Marcia");
		conta.setAgencia(22345);
		conta.setNumero(112344);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		
		EntityManager em2 = emf.createEntityManager();

		System.out.println("Id da Conta da Marcia:  " + conta.getId());
		conta.setSaldo(1000.0);
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}

}
