package com.Everis.Utils;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {

private static Logger logger = LogManager.getLogger(Tools.class);
	
	public static WebElement validateElementPresent(WebDriver driver, By by, String name) {
		
		WebElement webElement = null;
		
		try {
			webElement = driver.findElement(by);
		} catch (Exception ex) {
			String str = ex.toString(); 
			logger.error(str.substring(0, str.indexOf("}")) + "}");
			logger.error("No se encontró elemento " + name);
		}
		return webElement;
	}
	
	public static boolean goToTab(WebDriver driver, String tab, String name) {
		WebElement webElement = Tools.validateElementPresent(driver, By.xpath("//li[@id='" + tab + "']/a[2]/em/span/span"), name);
		if (webElement == null) {
			logger.error("No se pudo acceder a " + name + "(" + name + ")");
			return false;
		} else
			webElement.click();
		return true;
	}
	
	public static boolean waitForElementPresentById(WebDriver driver, String id, String name) throws TimeoutException {
		//Se espera (se valida a través de verificar existencia de botonera de acciones (elemento div))
		new WebDriverWait(driver, Long.parseLong(Config.getString("wait_expected"))).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		return true;
	}
	

	
	public static boolean waitForElementPresentByXPath(WebDriver driver, String xpath, String name) throws TimeoutException {
		//Se espera (se valida a través de verificar existencia de botonera de acciones (elemento div))
		new WebDriverWait(driver, Long.parseLong(Config.getString("wait_expected"))).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return true;
	}
	
	public static boolean selectComboOption(WebDriver driver, String id, String opt, String name) {

		Actions action = new Actions(driver);
		List<WebElement> webElements = null;
		
		name = name.trim();
		
		WebElement webElement = validateElementPresent(driver, By.id(id), "combo " + name );
		if (webElement == null) return false;
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			logger.error("No se pudo esperar obtener combo " + name);
			//e.printStackTrace();
		}
		
		webElement = webElement.findElement(By.tagName("img"));
		if (webElement == null) {
			logger.error("No se pudo desplegar combo " + name);
			return false;
		}
		action.click(webElement).perform();
		
		webElement =  validateElementPresent(driver, By.cssSelector(".x-view.x-combo-list-inner.x-component.x-unselectable"), "opciones combo " + name );
		if (webElement == null) return false;
		webElements = webElement.findElements(By.tagName("div"));
		if (webElements == null) return false;
		
		webElement = null;
		for (int i = 0; i < webElements.size(); i++) {
			if (webElements.get(i).getText().equals(opt)){
				webElement = webElements.get(i);
				action.click(webElement).perform();
				break;
			}
		}
		return true;
	}
	
}
