package AppHooks;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LearnAutomationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	public static ConfigReader configReader;
	Properties prop;
	//private static boolean isBrowserLaunched = false;
	
	//get data into prop from configReader like chrome from config 
	//properties file
	@Before(order=0)
	public void getProperty()
	{
		configReader  = new ConfigReader();
		prop = configReader.init_prop();
		}
	
	
	@Before(order = 1)
    public void launchBrowser() {
		// if (!isBrowserLaunched) {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		//Initialize webdriver which is passed in config.properties file
		driver = driverFactory.init_driver(browserName);	
		driver.get(prop.getProperty("url"));
	//	isBrowserLaunched = true;
	//	    } else {
		        driver = DriverFactory.getDriver(); // reuse existing driver
		    }
		
//	}

	@Before(order = 2)
	public void loginMethod() {
		
			LearnAutomationPage learnAutomationPage = new LearnAutomationPage(driver);
			learnAutomationPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
			
		}
		
		
	@AfterStep
	public void addDelay() throws InterruptedException {
	    Thread.sleep(500);
	}
	
	
//	@After()
	//public void tearDown() {
		// if (driver != null) {
		  //      driver.quit(); 
	//}
	
	
	
	
	
	//}
}
