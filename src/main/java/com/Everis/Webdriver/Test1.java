package com.Everis.Webdriver;

//import org.junit.Test;
/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.Test;
import junit.framework.TestSuite;
import com.Everis.Utils.Session;
*/

import com.Everis.Utils.Session;

import junit.framework.Test;
//import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test1 {


	public static Test suite(){
		
	//public void test(){
		
       TestSuite suite = new TestSuite();
		
		Session.startDriver();
		//return suite;
		
		if (Session.driver!=null){
			
			try{
			
			//suite.addTestSuite(TestBCI1.class);
			suite.addTestSuite(Step03_CP_03_01_015.class);
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		//}
		
		}
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

		
}
				
				
			
	
	
	

