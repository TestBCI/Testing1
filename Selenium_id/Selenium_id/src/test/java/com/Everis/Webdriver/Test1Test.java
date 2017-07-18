package com.Everis.Webdriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Everis.Utils.Config;
import com.Everis.Utils.Session;

public class Test1Test {

	public static WebDriver driver;
	private static Logger logger = LogManager.getLogger(Test1Test.class);
	@Test
	public void test() {
		logger.info("Conectandose...");
		
		try {
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
		}  catch (Exception ex) {
			logger.error(ex);
		}
	}

}
