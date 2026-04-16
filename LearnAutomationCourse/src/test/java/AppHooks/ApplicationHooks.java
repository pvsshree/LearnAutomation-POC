package AppHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

//import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
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
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		//Initialize webdriver which is passed in config.properties file
		driver = driverFactory.init_driver(browserName);	
	}
	
	//@After(order=0)
	//public void quitBrowser() {
	//driver.quit();	
	
	//}
	
	
	
	
	

}
