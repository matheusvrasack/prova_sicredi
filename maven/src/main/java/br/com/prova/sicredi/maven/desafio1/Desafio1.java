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

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Desafio1 {

	@Test
	public void testesDesafio1() throws InterruptedException {
		
		//Desafio 1!
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1.Acessar a página https://www.grocerycrud.com/demo/bootstrap_theme
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		
		//2.Mudar o valor da combo Select version para “Bootstrap V4 Theme”
		driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]/option[2]")).click();
		
		//3.Clicar no botão Add Customer
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
		
		//4.Preencher os campos do formulário com as seguintes informações:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"field-customerName\"]")).sendKeys("Teste Sicredi");
		driver.findElement(By.xpath("//*[@id=\"field-contactLastName\"]")).sendKeys("Teste");
		driver.findElement(By.xpath("//*[@id=\"field-contactFirstName\"]")).sendKeys("seu nome");
		driver.findElement(By.xpath("//*[@id=\"field-phone\"]")).sendKeys("51 9999-9999");
		driver.findElement(By.xpath("//*[@id=\"field-addressLine1\"]")).sendKeys("Av Assis Brasil, 3970");
		driver.findElement(By.xpath("//*[@id=\"field-addressLine2\"]")).sendKeys("Torre D");
		driver.findElement(By.xpath("//*[@id=\"field-city\"]")).sendKeys("Porto Alegre");
		driver.findElement(By.xpath("//*[@id=\"field-state\"]")).sendKeys("RS");
		driver.findElement(By.xpath("//*[@id=\"field-postalCode\"]")).sendKeys("91000-000");
		driver.findElement(By.xpath("//*[@id=\"field-country\"]")).sendKeys("Brasil");
		driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"field-creditLimit\"]")).sendKeys("200");
		
		//5.Clicar no botão Save
		driver.findElement(By.xpath("//*[@id=\"form-button-save\"]")).click();
		
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
