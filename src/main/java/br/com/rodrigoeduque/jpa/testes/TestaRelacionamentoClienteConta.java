package br.com.rodrigoeduque.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Cliente;
import br.com.rodrigoeduque.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setId(1L);
		
		Cliente cliente = new Cliente ();
		cliente.setNome("Jo�o");
		cliente.setConta(conta);
		cliente.setEndereco("Rua Anibal Pereira 86");
		cliente.setProfissao("Desenvolvedor");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
	}
}
