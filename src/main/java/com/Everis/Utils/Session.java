package com.Everis.Utils;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Session {

public static WebDriver driver;
	
	private static Logger logger = LogManager.getLogger(Session.class);
	
	private static String partyId;
	private static String contractId;
	private static String contractFormalDate;
	private static String contractSignDate;
	private static String contractfirstInstlDate;
	private static String invoiceNum;
	
	public static void startDriver() {
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
	
	public static void stopDriver() {
		logger.info("Desconectandose...");
		driver.quit();
	}

	public static String getPartyId() {
		return partyId;
	}

	public static void setPartyId(String partyId) {
		Session.partyId = partyId;
	}

	public static String getContractId() {
		return contractId;
	}

	public static void setContractId(String contractId) {
		Session.contractId = contractId;
	}

	public static String getContractFormalDate() {
		return contractFormalDate;
	}

	public static void setContractFormalDate(String contractFormalDate) {
		Session.contractFormalDate = contractFormalDate;
	}
	
	public static String getContractSignDate() {
		return contractSignDate;
	}

	public static void setContractSignDate(String contractSignDate) {
		Session.contractSignDate = contractSignDate;
	}

	public static String getContractfirstInstlDate() {
		return contractfirstInstlDate;
	}

	public static void setContractfirstInstlDate(String contractfirstInstlDate) {
		Session.contractfirstInstlDate = contractfirstInstlDate;
	}

	public static String getInvoiceNum() {
		return invoiceNum;
	}

	public static void setInvoiceNum(String invoiceNum) {
		Session.invoiceNum = invoiceNum;
	}
	
	
}
