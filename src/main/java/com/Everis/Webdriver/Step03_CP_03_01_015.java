package com.Everis.Webdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Everis.Utils.Config;
import com.Everis.Utils.Session;
import com.Everis.Utils.Tools;

import junit.framework.TestCase;

public class Step03_CP_03_01_015 extends TestCase {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	private static Logger logger = LogManager.getLogger(Step03_CP_03_01_015.class);
	
	@Before
	public void setUp() throws Exception {
		driver = Session.driver;
	}

	@Test
	public void test_CP_03_01_015_AltaCreditoConvencional() throws Exception {
		
		logger.info("Iniciando AltaCreditoConvencional");
		
		WebElement webElement = null;
		Actions action = new Actions(driver);
		
		//Completar datos del credito 
		
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[1]/div/div/span/span[2]/input"), "Nombre Cliente");
				if (webElement == null) assertTrue(false);
				webElement.sendKeys("Jesus");
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[2]/div/div/div[1]/span/span[2]/input"), "Rut");
				if (webElement == null) assertTrue(false);
				webElement.sendKeys("13.261.677-9");
					
				//Abrir combo sueldo 	
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[2]/div/div/div[2]/span/span[2]/span/div/div[1]/input"), "Sueldo");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//selecciona sueldo 2.000.000
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[2]/div/div/div[2]/span/span[2]/span/div/div[2]/div/div/div[4]/div/div"), "Sueldo");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//drop quiero 
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[3]/div/div/div[1]/span/span[2]/span/div/div[1]/input"), "quiero");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//Comprar 
				
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[3]/div/div/div[1]/span/span[2]/span/div/div[2]/div/div/div[2]/div/div"), "quiero");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//una propiedad
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[3]/div/div/div[2]/span/span[2]/span/div/div[1]/input"), "propiedad");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//nueva
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[3]/div/div/div[2]/span/span[2]/span/div/div[2]/div/div/div[2]/div/div"), "nueva");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//la propiedad es una 
				
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[4]/div/div/span/span[2]/span/div/div[1]/input"), "la propiedad");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//casa
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[1]/div[4]/div/div/span/span[2]/span/div/div[2]/div/div/div[2]/div/div"), "casa");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				//continuar 
				webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div[3]/div/div[2]/div/div/a"), "Continuar");
				if (webElement == null) assertTrue(false);
				webElement.click();
				
				
				
				
				
				//Completar campo RUT
				webElement = Tools.validateElementPresent(driver, By.id("pin-input"), "Rut");
				if (webElement == null) assertTrue(false);
				webElement.sendKeys(Config.getString("party_rut"));
		
		//Completar campo DESCRIPCIÓN
		webElement = Tools.validateElementPresent(driver, By.id("contratDescription-input"), "Descripción");
		webElement.sendKeys("PRUEBA");
		
		//Seleccionar RED
		if (!Tools.selectComboOption(driver, "network", "AUTO - RED AUTO", "Red")) assertTrue(false);
		
		//Ir a busqueda PROVEEDOR
		webElement = Tools.validateElementPresent(driver, By.id("supplier"), "Proveedor");
		webElement = webElement.findElement(By.tagName("img"));
		action.click(webElement).perform();
		
		//Buscar PROVEEDOR
		webElement = Tools.validateElementPresent(driver, By.xpath("(//input[@id='partyId-input'])[3]"), "Id proveedor");
		webElement.sendKeys(Config.getString("supplier_id"));
		webElement = Tools.validateElementPresent(driver, By.xpath("//table[@id='SupplierSearch-searchButton']/tbody/tr[2]/td[2]/em/button"), "botón Buscar proveedor");
		if (webElement == null) assertTrue(false);
		webElement.click();
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		
		//Selecciona PROVEEDOR
		webElement = driver.findElement(By.xpath("//div[@id='result']/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));
		if (webElement == null) assertTrue(false);
		action.doubleClick(webElement).perform();
		
		//Ir a busqueda CLIENTE
		webElement = Tools.validateElementPresent(driver, By.id("party"), "Cliente");
		webElement = webElement.findElement(By.tagName("img"));
		action.click(webElement).perform();
		
		//Buscar CLIENTE
		webElement = Tools.validateElementPresent(driver, By.xpath("(//input[@id='partyId-input'])[3]"), "Id cliente");
		if (Session.getPartyId() != null && !Session.getPartyId().equals(""))
			webElement.sendKeys(Session.getPartyId());
		else
			webElement.sendKeys(Config.getString("party_id"));
		webElement = Tools.validateElementPresent(driver, By.xpath("//table[@id='GeneralCustomerSearch-searchButton']/tbody/tr[2]/td[2]/em/button"), "botón Buscar cliente");
		if (webElement == null) assertTrue(false);
		webElement.click();
		
		//Selecciona CLIENTE
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		webElement = driver.findElement(By.xpath("//div[@id='result']/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));
		if (webElement == null) assertTrue(false);
		action.doubleClick(webElement).perform();
		
		//Seleccionar TIPO DEL BIEN
		if (!Tools.selectComboOption(driver, "assetNatureCode", "AUTO - AUTOMOVIL", "Tipo de bien")) assertTrue(false);
		
		//Seleccionar CÓDIGO IVA
		if (!Tools.selectComboOption(driver, "taxCode", "0 - EXENTO - HORS", "Código IVA")) assertTrue(false);
		
		//Completar campo DESCRIPCIÓN
		webElement = Tools.validateElementPresent(driver, By.id("description-input"), "Descripción");
		webElement.sendKeys("AUTO");
		
		//Completar campo PRECIO DEL BIEN
		webElement = Tools.validateElementPresent(driver, By.id("assetAmt-input"), "Precio del bien");
		webElement.sendKeys("8000000");
		
		//Completar campo TASA NOMINAL
		webElement = Tools.validateElementPresent(driver, By.xpath("(//input[@id='nominalRate-input'])[2]"), "Tasa nominal");
		webElement.sendKeys("12");
		
		//Completar campo NUMERO DE CUOTAS
		webElement = Tools.validateElementPresent(driver, By.id("installmentNb-input"), "Numero de cuotas");
		webElement.click();
		webElement.sendKeys("24");
		
		//Completar campo PLAZO CUOTA
		webElement = Tools.validateElementPresent(driver, By.id("installmentDuration-input"), "Plazo cuota");
		webElement.sendKeys("1");
		
		//Guardar
		webElement = Tools.validateElementPresent(driver, By.xpath("//table[@id='AdvancedAllocatedLoanCreation-save']/tbody/tr[2]/td[2]/em/button"), "Guardar");
		if (webElement == null) assertTrue(false);
		webElement.click();
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		
		assertTrue(Tools.waitForElementPresentById(driver, "AdvancedAllocatedLoanUpdate-save", "Alta credito convencional"));
		
		//Obtener id asignado a contrato
		webElement = Tools.validateElementPresent(driver, By.id("ieContract-input"), "Número contrato");
		if (webElement != null) {
			Session.setContractId(webElement.getAttribute("value"));
			logger.info("Contrato ID: " + Session.getContractId());
		}
		
		//Valida estado del contrato de credito
		Thread.sleep(Long.parseLong(Config.getString("wait_values")));
		webElement = Tools.validateElementPresent(driver, By.id("contractHistoryStatus-input"), "Estado");
		if (webElement == null)
			assertTrue(false);
		else if (!webElement.getAttribute("value").equals("A000 - EN CREACION"))
			assertTrue(false);
		else
			assertTrue(true);
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