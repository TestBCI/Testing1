package com.Everis.Webdriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Everis.Utils.Config;
import com.Everis.Utils.Session;
import com.Everis.Utils.Tools;

public class Test2 {

	
	private static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
	private static Logger logger = LogManager.getLogger(Step03_CP_03_01_015.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		driver = Session.driver;
	
	}
	



	@Test
	public void test() {
		
		logger.info("Conectandose...");
		WebElement webElement = null;
				
 				switch (Config.getString("driver")) {
					case "chrome":
						System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
						driver = new ChromeDriver();
						break;
					case "firefox":
						driver = new FirefoxDriver();
						break;
						
					}
					
					driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.getString("wait_implicit")), TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get(Config.getString("host") + Config.getString("path"));
					//driver.findElement(By.id("j_username")).clear();
					//driver.findElement(By.id("j_username")).sendKeys(Config.getString("user"));
					//driver.findElement(By.id("j_password")).clear();
					//driver.findElement(By.id("j_password")).sendKeys(Config.getString("pass"));
					driver.findElement(By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/div/div[2]/div/div/div[1]/button")).click();
					//driver.findElement(By.xpath("holamundo")).click();
					//webElement = Tools.validateElementPresent(driver, By.xpath("//*[@id='form']/div/ui-view/ui-view/ui-view/section/"), "Nombre Cliente");
					//if (webElement == null) assertTrue(false);
        
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		 logger.info("Fin");
			
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
	}

}
