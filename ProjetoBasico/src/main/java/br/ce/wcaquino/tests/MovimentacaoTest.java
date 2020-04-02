package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;


public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testInserirMovimentacao(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/09/2018");
		movPage.setDataPagamento("02/09/2018");
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setDescricao("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("outra conta 2");
		movPage.setStatusPago();
		movPage.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!" , movPage.obterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Iteressado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		Assert.assertEquals(6, erros.size());
	}
}
