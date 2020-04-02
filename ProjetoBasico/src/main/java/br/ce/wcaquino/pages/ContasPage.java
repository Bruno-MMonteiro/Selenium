package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	public void clicarAlterarConta(String string) {
		ObterCelula("Conta", string, "A��es", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
}