package stepdefinitions;

import org.junit.Assert;

import com.pages.LearnAutomationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LearnAutomationSteps {
	//private static String title;
	private LearnAutomationPage learnAutomationPage = new LearnAutomationPage(DriverFactory.getDriver());

	@Given("User should be on login page")
	public void user_should_be_on_login_page() {
	    DriverFactory.getDriver().get("https://freelance-learn-automation.vercel.app/login");
	}
	
	//@when is already present in LoginPageSteps.java so it will refer from that

	@Then("Page title should be {string}")
	public void page_title_should_be(String expFeatureFileTitle) {
		String actualTitle = DriverFactory.getDriver().getTitle();
		//String heading = learnAutomationPage.getTitleOfPage();
//		Assert.assertTrue(actualTitle.contains(expFeatureFileTitle));
	    
	}
	
	
	@When("User enters email {string}")
	public void user_enters_email(String email) {
		learnAutomationPage.enterUsername(email );
	}

	@When("User enters pwd {string}")
	public void user_enters_pwd(String pswd) {
	    
		learnAutomationPage.enterPassword(pswd);
	}


	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		learnAutomationPage.clickOnSignIn();
	    
	}

	@Then("User navigates to Home page")
	public void user_navigates_to_home_page() {
	    
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
