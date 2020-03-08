package utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest1 {

	
	
	/*log4j implementation*/
	public static final Logger log = Logger.getLogger(BaseTest1.class.getName());
	/*Extent report variable*/
	public static ExtentReports extent;
	public static ExtentTest test;
	/*initiate Driver*/
	public WebDriver driver;
	
	
	@BeforeClass
		
		/*Configure Log4j*/
		public void init() throws IOException {
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			selectBrowser(System.getProperty("browser"));
			driver.manage().window().maximize();
			driver.get("http://demowebshop.tricentis.com/");
			extent = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
			test = extent.startTest("DemoShop Test Run Result");	
		
	}

	/*Initiate the browser*/
	private void selectBrowser(String browser) {
		// TODO Auto-generated method stub
		if(browser.equals("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
			driver =new FirefoxDriver();		
		}
				
	}
	
	public static WebElement waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	
	/*ENd test by call this function*/
	@AfterClass(alwaysRun = true)
	public void EndTest() {
		driver.quit();
		log.info("browser closed");
		extent.endTest(test);
		extent.flush();
			
	}
	
	
}
