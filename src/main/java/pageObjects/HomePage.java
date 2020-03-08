package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseTest1;

public class HomePage extends BaseTest1 {

	
	WebDriver driver;
	
	
	/* Top menu links start */
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginTopMenu;

	@FindBy(xpath = "//*[@id='topcartlink']/a")
	WebElement shoppingCartTopMenu;

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerTopMenuLinks;

	@FindBy(xpath = "//a[@class='ico-wishlist']/span[1]")
	WebElement wishListButtonTopMenu;

	@FindBy(xpath = "//a[@class='ico-wishlist']/span[2]")
	WebElement wishListCountTopMenu;

	/**************************
	 * Top menu links end
	 **************************************/

	/* Login page webElemnts start */

	@FindBy(xpath = "//*[@id='Email']")
	WebElement emailTextField;

	@FindBy(xpath = "//*[@id='Password']")
	WebElement passwordTextField;

	@FindBy(xpath = "//*[@id='RememberMe']")
	WebElement rememberMeCheckbox;

	@FindBy(xpath = "//span[@class='forgot-password']")
	WebElement forgetPasswordlink;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginButton;

	/**************************
	 * Login page webElemnts End
	 *********************************/

	@FindBy(xpath = "//*[contains(text(),'akash@test.test')]")
	WebElement verifyUserName;
	
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void loginToPage() throws Throwable {
		waitForElement(driver, loginTopMenu, 30);
		loginTopMenu.click();
		log.info("Clicked on login button");
		emailTextField.sendKeys("akash@test");
		log.info("email entered by user ");
		passwordTextField.sendKeys("password");
		log.info("password entered by user ");
		loginButton.click();
		log.info("user clicked Login Button ");
		Thread.sleep(30000);
	}
	
	
	
	
	
}
	
	

