package br.ifsp.qswl5.ApostaLucasPedroOtavio;

import model.Aposta;
import model.Usuario;
import org.junit.Test;
import org.junit.Before;

import junit.framework.TestCase;
import model.Partida;


public class PartidaTeste extends TestCase {
	String time_mandante = "Time 1";
	String time_visitante = "Time 2";
	String nome_campeonato = "Campeonato Estadual";

	Partida partida_pronta = new Partida();
	@Before
	public void init() {
		partida_pronta.setTimeMandante(time_mandante);
		partida_pronta.setTimeVisitante(time_visitante);
		partida_pronta.setCampeonato(nome_campeonato);
	}

	@Test
	public void testeCriarPartida() {
		String time_mandante = "Time 1";
		String time_visitante = "Time 2";
		String nome_campeonato = "Campeonato Estadual";

		Partida partida = new Partida();
		partida.setTimeMandante(time_mandante);
		partida.setTimeVisitante(time_visitante);
		partida.setCampeonato(nome_campeonato);

		// Nome da partida está sendo criado incorretamente apesar dos parâmetros estarem corretos
		assertTrue(partida.getCampeonato().contains(time_mandante));
	}

	@Test
	public void testeGetStatus() {
		assertFalse(partida_pronta.estaDisponivelReceberApostas());
		partida_pronta.liberarApostas();
		assertTrue(partida_pronta.estaDisponivelReceberApostas());
	}

	@Test
	public void testeEnviarApostaAntesDeLiberar() {
		String email_valido = "jeffersson@itau.com.br";
		String cpf_valido = "79877350009";
		String password_valida = "!123456";
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);

		Aposta aposta = new Aposta();
		aposta.setApostador(user);

		partida_pronta.enviarAposta(aposta);

		assertEquals(partida_pronta.getNumeroApostas(), 1);
		// A aposta é colocada na fila de apostas apesar da partida não estar disponível para apostas
		assertTrue(partida_pronta.estaDisponivelReceberApostas());
	}

	@Test
	public void testeEnviarApostaDepoisDeLiberar() {
		String email_valido = "jeffersson@itau.com.br";
		String cpf_valido = "79877350009";
		String password_valida = "!123456";
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);

		Aposta aposta = new Aposta();
		aposta.setApostador(user);

		partida_pronta.liberarApostas();
		partida_pronta.enviarAposta(aposta);

		assertEquals(partida_pronta.getNumeroApostas(), 1);
		assertTrue(partida_pronta.estaDisponivelReceberApostas());
	}
}
