package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcaquino.pages.LoginPage;



public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "D:\\Users\\Bruno\\Downloads\\gecko\\geckodriver.exe");
		page.acessarTelaInicial();
		page.setEmail("bruno_giraya@hotmail.com");
		page.setSenha("caosbreak22");
		page.entrar();
		
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/screenshot/" +
				 testName.getMethodName() + ".jpg"));
		if(Propriedades.FECHAR_BROWSER)
		killDriver();
	}
}
