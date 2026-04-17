package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.awt.PopupMenu;
import java.awt.Window;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

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

	@When("User hovers to Manage see the dropdown options")
	public void user_hovers_to_manage_see_the_dropdown_options() throws InterruptedException {
		homePage.hoverOnManage();
		//Thread.sleep(1000);
		
	    
	}

	@When("User clicks on Manage Courses")
	public void user_clicks_on_manage_courses() throws InterruptedException {
		homePage.clickOnManageCourses();
		//Thread.sleep(3000);
	   
	}

	@Then("User navigates to Manage Courses page")
	public void user_navigates_to_manage_courses_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("manage"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		
		
	    
	}

	@When("User clicks on Add New Course")
	public void user_clicks_on_add_new_course() {
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		
	   homePage.addNewCourse();
	}

	@Then("Popup for Add New Course should be displayed")
	public void popup_for_add_new_course_should_be_displayed() {
		homePage.popUpForAddNew();
//	Assert.assertTrue(
		}
	

		@Given("User is on Add New Course popup")
		public void user_is_on_add_new_course_popup() {
			homePage.addNewCourse();
		}



	
		@When("Click on Save Button without entering values")
		public void verifySave() {
			homePage.saveButton();
	//	Assert.assertTrue(
			}
		
		@Then("Message {string} should be diplayed")
		public void textMsg(String expected) {
		String actual =	homePage.textMsgWeb();
		Assert.assertTrue(actual.contains(expected));
			
		}
		
		
		@When("User clicks on choose file and selects a file")
		public void user_clicks_on_choose_file_and_selects_a_file() {
		    homePage.chooseFilePng();
		}

		@Then("That file should be selected")
		public void that_file_should_be_selected() {
		    
		}






}
