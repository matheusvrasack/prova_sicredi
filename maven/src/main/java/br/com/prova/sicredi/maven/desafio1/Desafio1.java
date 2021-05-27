package br.com.prova.sicredi.maven.desafio1;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.prova.sicredi.pageObjects.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Desafio1 {
	
	@Test
	public void testesDesafio1() throws InterruptedException {
		//Desafio 1!
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//1.Acessar a página https://www.grocerycrud.com/demo/bootstrap_theme
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		
		PageObjects objects = new PageObjects(driver);
		objects.click1().click();
		objects.click2().click();
		//2.Mudar o valor da combo Select version para “Bootstrap V4 Theme”
	
		//3.Clicar no botão Add Customer
		Thread.sleep(5000);
		objects.click3().click();

		//4.Preencher os campos do formulário com as seguintes informações:
		Thread.sleep(3000);
		objects.sendKeys1().sendKeys("Teste Sicredi");
		objects.sendKeys2().sendKeys("Teste");
		objects.sendKeys3().sendKeys("seu nome");
		objects.sendKeys4().sendKeys("51 9999-9999");
		objects.sendKeys5().sendKeys("Av Assis Brasil, 3970");
		objects.sendKeys6().sendKeys("Torre D");
		objects.sendKeys7().sendKeys("Porto Alegre");
		objects.sendKeys8().sendKeys("RS");
		objects.sendKeys9().sendKeys("91000-000");
		objects.sendKeys10().sendKeys("Brasil");
		objects.click4().click();
		objects.click5().sendKeys("Fixter",Keys.ENTER);
		objects.sendKeys12().sendKeys("200");
		
		//5.Clicar no botão Save
		objects.click6().click();
	
		//6.Validar a mensagem “Your data has been successfully stored into the database. Edit Customer or Go back to list” através de uma asserção
		String textoEsperado = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		WebDriverWait waitText = new WebDriverWait (driver,10);
		WebElement text = waitText.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#report-success")));
		String texto = driver.findElement(By.cssSelector("#report-success > p")).getText();
		Assert.assertEquals(textoEsperado,texto);
		
		//7.Fechar o browser
		driver.close();
		driver.quit();
	}
}
