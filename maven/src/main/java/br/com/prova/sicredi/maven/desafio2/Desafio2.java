package br.com.prova.sicredi.maven.desafio2;

import static org.junit.Assert.*;

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

public class Desafio2 {

	@Test
	public void testesDesafio2() throws InterruptedException {
		
		//Desafio 2!
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
		//driver.close();
		//driver.quit();
		
		//1.Clicar no link Go back to list
		driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]")).click();
		
		//2.Clicar na coluna “Search Name” e digitar o conteúdo do Name (Teste Sicredi)
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input")).sendKeys("Teste Sicredi");
		
		//3.Clicar no checkbox abaixo da palavra Actions
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr[1]/td[1]/input")).click();
		
		//4.Clicar no botão Delete
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")).click();
		
		//5.Validar o texto “Are you sure that you want to delete this 1 item?” através de uma asserção para a popup que será apresentada
		String textoPopupEsperado = "Are you sure that you want to delete this 1 item?";
		WebDriverWait waitPopup = new WebDriverWait (driver,10);
		WebElement textPopup = waitPopup.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]")));
		String textoPopup = driver.findElement(By.cssSelector("body > div.container-fluid.gc-container > div.row > div.delete-multiple-confirmation.modal.fade.in.show > div > div > div.modal-body > p.alert-delete-multiple-one")).getText();
		Assert.assertEquals(textoPopupEsperado,textoPopup);
		
		//6.Clicar no botão Delete da popup, aparecerá uma mensagem dentro de um box verde na parte superior direito da tela. Adicione uma asserção na mensagem “Your data has been successfully deleted from the database.”
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();

		String textoDeleteEsperado = "Your data has been successfully deleted from the database.";
		WebDriverWait waitDelete = new WebDriverWait (driver,10);
		WebElement textDelete = waitDelete.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/span[3]/p")));
		String textoDelete = driver.findElement(By.xpath("/html/body/div[3]/span[3]/p")).getText();
		Assert.assertEquals(textoDeleteEsperado,textoDelete);
		
		//7.Fechar o browser
		driver.close();
		driver.quit();
	}

	
}
