package br.com.rodrigoeduque.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		//Nesse momento ainda é um objeto Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(1234);
		conta.setNumero(122543);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		// Estou transformando o estado do objeto de Transient -> Managed
		em.persist(conta);
		
		// Estou transformando o estado do objeto de Managed-> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}
