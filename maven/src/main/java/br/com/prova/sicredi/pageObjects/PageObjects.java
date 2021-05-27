package br.com.prova.sicredi.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObjects {
	WebDriver driver;

	@FindBy(id = "switch-version-select")
	WebElement click1;
	
	@FindBy(xpath = "//*[@id=\"switch-version-select\"]/option[2]")
	WebElement click2;
	
	@FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[1]/div[1]")
	WebElement click3;
	
	@FindBy(id = "field-customerName")
	WebElement sendKeys1;
	
	@FindBy(id = "field-contactLastName")
	WebElement sendKeys2;
	
	@FindBy(id = "field-contactFirstName")
	WebElement sendKeys3;
	
	@FindBy(id = "field-phone")
	WebElement sendKeys4;
	
	@FindBy(id = "field-addressLine1")
	WebElement sendKeys5;
	
	@FindBy(id = "field-addressLine2")
	WebElement sendKeys6;
	
	@FindBy(id = "field-city")
	WebElement sendKeys7;
	
	@FindBy(id = "field-state")
	WebElement sendKeys8;
	
	@FindBy(id = "field-postalCode")
	WebElement sendKeys9;
	
	@FindBy(id = "field-country")
	WebElement sendKeys10;
	
	@FindBy(xpath = "//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span")
	WebElement click4;
	
	@FindBy(xpath = "//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")
	WebElement click5;
	
	@FindBy(xpath = "//*[@id=\"field-creditLimit\"]")
	WebElement sendKeys12;

	@FindBy(id = "form-button-save")
	WebElement click6;
	
	@FindBy(xpath = "//*[@id=\"report-success\"]/p/a[2]")
	WebElement click7;
	
	@FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input")
	WebElement click8;
	
	@FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input")
	WebElement sendKeys13;

	@FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[1]/input")
	WebElement click9;
	
	@FindBy(xpath = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")
	WebElement click10;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")
	WebElement click11;
	
	public PageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		}

		public WebElement click1() {
			return (click1);
		}
		
		public WebElement click2() {
			return (click2);
		}
		
		public WebElement click3() {
			return (click3);
		}
		
		public WebElement sendKeys1() {
			return (sendKeys1);
		}
		
		public WebElement sendKeys2() {
			return (sendKeys2);
		}
		
		public WebElement sendKeys3() {
			return (sendKeys3);
		}
		public WebElement sendKeys4() {
			return (sendKeys4);
		}
		public WebElement sendKeys5() {
			return (sendKeys5);
		}
		
		public WebElement sendKeys6() {
			return (sendKeys6);
		}
		
		public WebElement sendKeys7() {
			return (sendKeys7);
		}
		
		public WebElement sendKeys8() {
			return (sendKeys8);
		}
		
		public WebElement sendKeys9() {
			return (sendKeys9);
		}
		public WebElement sendKeys10() {
			return (sendKeys10);
		}
		public WebElement click4() {
			return (click4);
		}
		
		public WebElement click5() {
			return (click5);
		}
		public WebElement sendKeys12() {
			return (sendKeys12);
		}
		public WebElement click6() {
			return (click6);
		}
		public WebElement click7() {
			return (click7);
		}
		public WebElement click8() {
			return (click8);
		}
		public WebElement sendKeys13() {
			return (sendKeys13);
		}
		public WebElement click9() {
			return (click9);
		}
		public WebElement click10() {
			return (click10);
		}
		public WebElement click11() {
			return (click11);
		}
	
}
