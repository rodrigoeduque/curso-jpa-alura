package br.com.rodrigoeduque.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Conta;
import br.com.rodrigoeduque.jpa.modelo.Movimentacao;
import br.com.rodrigoeduque.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentos {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		Conta conta = new Conta();
		conta.setTitular("Marlene");
		conta.setAgencia(144427);
		conta.setNumero(1235456);
		conta.setSaldo(123.00);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Salão");
		movimentacao.setValor(new BigDecimal(100));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();

	}
}
