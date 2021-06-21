package br.com.rodrigoeduque.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rodrigoeduque.jpa.modelo.Categoria;
import br.com.rodrigoeduque.jpa.modelo.Conta;
import br.com.rodrigoeduque.jpa.modelo.Movimentacao;
import br.com.rodrigoeduque.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
	
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		Categoria categoria3= new Categoria("Alimentação");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a São Paulo");
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(300.00));
		List<Categoria> categorias = new ArrayList<Categoria>();
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setDescricao("Viagem a Uberlândia");
		movimentacao1.setData(LocalDateTime.now());
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal(400.00));
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(categoria3);
		em.persist(movimentacao);
		em.persist(movimentacao1);		
		em.getTransaction().commit();
		em.close();

		
}	


}
