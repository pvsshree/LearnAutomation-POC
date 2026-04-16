package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.pages.HomePage;
import com.pages.LearnAutomationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HomeSteps {
	
	
	//creating object of LearnAutomationPage class
	private LearnAutomationPage learnAutomationPage = new LearnAutomationPage(DriverFactory.getDriver());
	//creating object of CartPage class in doLogin() method
	private HomePage homePage;
	String text;
	
	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) throws InterruptedException {
	    List<Map<String,String>> credentialList =  dataTable.asMaps();
	    String email = credentialList.get(0).get("email");
	    String password = credentialList.get(0).get("password");
	    DriverFactory.getDriver().get("https://freelance-learn-automation.vercel.app/login");
	   
	    //this will call dologin from loginpage and store it into object of homepage
	    homePage = learnAutomationPage.doLogin(email, password);
	    Thread.sleep(5000);
	    
	    
	}

	@Given("User is on {string}")
	public void user_is_on(String text) {
		this.text = text;
		System.out.println(text);
//		assertEquals("Learn Automation Courses", homePage.getTitleAsHomePage());
	   
	}

	@When("User hovers to Manage see the dropdown options")
	public void user_hovers_to_manage_see_the_dropdown_options() throws InterruptedException {
		homePage.hoverOnManage();
		Thread.sleep(1000);
		
	    
	}

	@When("User clicks on Manage Courses")
	public void user_clicks_on_manage_courses() throws InterruptedException {
		homePage.clickOnManageCourses();
		Thread.sleep(3000);
	   
	}

	@Then("User navigates to Manage Courses page")
	public void user_navigates_to_manage_courses_page() {
		
	    
	}


	@When("User clicks on Add New Course")
	public void user_clicks_on_add_new_course() {
		homePage.addNewCourse();
	   
	}

	@Then("Popup for Add New Course should be displayed")
	public void popup_for_add_new_course_should_be_displayed() {
	    
	}
	





}
