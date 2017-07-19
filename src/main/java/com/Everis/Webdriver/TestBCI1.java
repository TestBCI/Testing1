package com.Everis.Webdriver;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Everis.Utils.Config;
import com.Everis.Utils.Session;
import com.Everis.Utils.Tools;

import junit.framework.TestCase;



public class TestBCI1 extends TestCase {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private static Logger logger = LogManager.getLogger(TestBCI1.class);
	
	@Before
	public void setUp() throws Exception {
		driver = Session.driver;
	}
	
	@Test
	public void IngresoCredito() throws Exception {
		
		logger.info("Iniciando Credito");
		
		WebElement webElement = null;
		List<WebElement> webElements = null;
		Actions action = new Actions(driver);
		
		//Completar datos del credito 
		
		webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[1]/div/div/span/span[2]/input"), "Nombre Cliente");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("Jesus");
		webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[2]/div/div/div[1]/span/span[2]/input"), "Rut");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("13.261.677-9");
		webElement = Tools.validateElementPresent(driver, By.xpath("//a[contains(text(),'Alta persona con giro CL')]"), "Alta persona con giro CL");
		if (webElement == null) assertTrue(false);
		webElement.click();
		
		//Completar campo RUT
		webElement = Tools.validateElementPresent(driver, By.id("pin-input"), "Rut");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys(Config.getString("party_rut"));
		
		//Completar campo NOMBRE y APELLIDO
		webElement = Tools.validateElementPresent(driver, By.id("forename-input"), "Nombre");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys(Config.getString("party_first_name"));
		webElement = Tools.validateElementPresent(driver, By.id("name-input"), "Apellido paterno");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys(Config.getString("party_last_name"));
		
		webElement = Tools.validateElementPresent(driver, By.id("mdnName-input"), "Apellido materno");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys(Config.getString("party_last_name"));
		
		//Seleccionar TIPO PERSONA
		if (!Tools.selectComboOption(driver, "personType", "PNA - PERSONA NATURAL SIN Y CON GIRO", "Tipo persona")) assertTrue(false);
				
		//Seleccionar TRATAMIENTO
		if (!Tools.selectComboOption(driver, "partyQuality", "SR - SEÑOR", "Tratamiento")) assertTrue(false);
		
		//Completar CALLE
		webElement = Tools.validateElementPresent(driver, By.id("address-input"), "Calle");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("AVDA. SIEMPREVIVA");
		
		//Completar NUMERO
		webElement = Tools.validateElementPresent(driver, By.id("streetNr-input"), "N° calle");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("742");
		
		//Completar campo REGION
		webElement = Tools.validateElementPresent(driver, By.id("departement-input"), "Region");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("REGION");
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		webElement = Tools.validateElementPresent(driver, By.cssSelector(".x-view.x-combo-list-inner.x-component.x-unselectable"), "Region");
		if (webElement == null) assertTrue(false);
		webElements = webElement.findElements(By.tagName("div"));
		webElement = null;
		for (int i = 0; i < webElements.size(); i++) {
			if (webElements.get(i).getText().equals("REGION METROPOLITANA DE SANTIAGO")){
				webElement = webElements.get(i);
				action.click(webElement).perform();
				break;
			}
		}
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		
		//Completar campo COMUNA-CIUDAD
		webElement = Tools.validateElementPresent(driver, By.xpath("(//input[@id='town-input'])[2]") , "Comuna-Ciudad");
		if (webElement == null) assertTrue(false);
		webElement.sendKeys("SANTIAGO");
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		webElement = Tools.validateElementPresent(driver, By.cssSelector(".x-view.x-combo-list-inner.x-component.x-unselectable"), "Comuna-Ciudad");
		if (webElement == null) assertTrue(false);
		webElements = webElement.findElements(By.tagName("div"));
		webElement = null;
		for (int i = 0; i < webElements.size(); i++) {
			if (webElements.get(i).getText().equals("SANTIAGO - SANTIAGO")) {
				webElement = webElements.get(i);
				action.click(webElement).perform();
				break;
			}
		}
		
		//Seleccionar CODIGO ROL
		if (!Tools.selectComboOption(driver, "roleCode", "CLIE - CLIENTE", "Código rol")) assertTrue(false);
		
		//Guardar
		webElement = Tools.validateElementPresent(driver, By.xpath("//table[@id='ChileanProfessionalPartyCreation-save']/tbody/tr[2]/td[2]/em/button"), "Guardar");
		if (webElement == null) assertTrue(false);
		webElement.click();
		
		assertTrue(Tools.waitForElementPresentById(driver, "ChileanProfessionalPartyUpdate-screen-menu", "Alta persona natural"));
		
		//Obtener RUT
		webElement = Tools.validateElementPresent(driver, By.id("pin-input"), "RUT");
		if (webElement != null) {
			logger.info("Persona RUT: " + webElement.getAttribute("value"));
		}
				
		//Obtener id asignado a persona
		webElement = Tools.validateElementPresent(driver, By.id("partyId-input"), "ID entidad");
		if (webElement != null) {
			Session.setPartyId(webElement.getAttribute("value"));
			logger.info("Persona ID: " + Session.getPartyId());
		}
		
		//Validar existencia de elemento (para validar si guardó persona)
		assertTrue((webElement != null) ? true : false);
	}
	
	@After
	public void tearDown() throws Exception {
		logger.info("Fin");
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	
}
