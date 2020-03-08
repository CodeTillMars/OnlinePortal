package HomePageTest;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import utils.BaseTest1;

public class TC0001_HomePage extends BaseTest1 {
	
	
	@Test
	public void verifyHomepage() throws Throwable{
		
		HomePage call= new HomePage(driver);
		
		
		
		log.info("===========verifyLoginWithInvalidCredentails test===========");
		call.loginToPage();
		
		
	}
	
	
	
}