package br.ifsp.qswl5.ApostaLucasPedroOtavio;

import org.junit.Test;
import org.junit.Before;

import junit.framework.TestCase;
import model.Usuario;


public class UsuarioTeste extends TestCase {
	String email_valido;
	String email_invalido;
	String password;
	String cpf_valido;
	String cpf_invalido1;
	String cpf_invalido2;
	String password_invalida;
	String password_valida;
	
	@Before
	public void init() {
		email_valido = "jeffersson@itau.com.br";
		email_invalido = "jeffersson.com.br";
		cpf_valido = "79877350009";
		cpf_invalido1 = "123456789";
		cpf_invalido2 = "123456789100";
		password_invalida = "123456";
		password_valida = "!123456";
	}
	
	@Test
	public void testeCriarUsuarioCpfInvalido1() {
		Usuario user = new Usuario(email_valido, cpf_invalido1, password_valida);
		assertEquals(user.getEmail(), null);
	}
	
	@Test
	public void testeCriarUsuarioCpfInvalido2() {
		Usuario user = new Usuario(email_valido, cpf_invalido2, password_valida);
		assertEquals(user.getEmail(), null);
	}
	
	@Test
	public void testeCriarUsuarioPasswordInvalido() {
		Usuario user = new Usuario(email_valido, cpf_valido, password_invalida);
		assertEquals(user.getEmail(), null);
	}
	
	@Test
	public void testeCriarUsuarioEmailInvalido() {
		Usuario user = new Usuario(email_invalido, cpf_valido, password_valida);
		assertEquals(user.getEmail(), null);
	}
	
	@Test
	public void testeCriarUsuarioValido() {
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);
		assertEquals(user.getEmail(), email_valido);
	}
	
	@Test
	public void testeGetMoedas() {
		float expected_moedas = 200;
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);
		assertEquals(user.getMoedas(), expected_moedas);
	}
	
	@Test
	public void testeTemSaldoSuficiente() {
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);
		assertTrue(user.temSaldoSuficiente());
	}
	
	@Test
	public void testeDiminuirMoedas() {
		float expected_moedas = 150;
		Usuario user = new Usuario(email_valido, cpf_valido, password_valida);
		user.diminuirMoedas();
		assertEquals(user.getMoedas(), expected_moedas);
	}
}
