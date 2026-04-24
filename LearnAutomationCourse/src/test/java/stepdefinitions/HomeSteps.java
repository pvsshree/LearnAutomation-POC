	package stepdefinitions;
	
	import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.PopupMenu;
	import java.awt.Window;
	import java.security.PublicKey;
	import java.util.List;
	import java.util.Map;
	import java.util.Properties;
	
	import org.openqa.selenium.WebDriver;
	
	import com.pages.HomePage;
	import com.pages.LearnAutomationPage;
	import com.qa.factory.DriverFactory;
	
	import AppHooks.ApplicationHooks;
	import io.cucumber.datatable.DataTable;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import junit.framework.Assert;
	
	public class HomeSteps {
		
		
		//creating object of LearnAutomationPage class
	//	private LearnAutomationPage learnAutomationPage = new LearnAutomationPage(DriverFactory.getDriver());
		//creating object of CartPage class in doLogin() method
		WebDriver driver = DriverFactory.getDriver();
		private HomePage homePage = new HomePage(driver);
		
		
		
		@Given("User has already logged in to application")
		
		public void user_has_already_logged_in_to_application(){
		//    DriverFactory.getDriver().get(ApplicationHooks.configReader.getUrl());
		//    driver.get(ApplicationHooks.configReader.getUrl());
		   
		    //this will call dologin from loginpage and store it into object of homepage
	//	  homePage = learnAutomationPage.doLogin();
		    
		   }
		
		
		@When("User is on home page")
		public void userIsOnHomePage() {
	//		driver.get("https://freelance-learn-automation.vercel.app");
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
			Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("manage"));
			System.out.println(DriverFactory.getDriver().getCurrentUrl());
			
			
		    
		}
	
		@When("User clicks on Add New Course")
		public void user_clicks_on_add_new_course() throws InterruptedException {
		//	driver.get("https://freelance-learn-automation.vercel.app/course/manage");
			System.out.println(DriverFactory.getDriver().getCurrentUrl());
			
		   homePage.addNewCourse();
		   Thread.sleep(3000);
		}
	
		@Then("Popup for Add New Course should be displayed")
		public void popup_for_add_new_course_should_be_displayed() {
			homePage.popUpForAddNew();
	//	Assert.assertTrue(
			}
		
		
		
	//-------------------------------------------------------GIVEN FOR ADD NEW COURSE POPUP--------------------------------------------------
		
		
		@Given("User is on Add New Course popup")
			public void user_is_on_add_new_course_popup() {
			homePage.addNewCourse();
			}
	
	
		
		
	//----------------------------------------------------------SAVE BUTTON---------------------------------------------------------------
			
		
			@When("Click on Save Button without entering values")
			public void verifySave() {
				homePage.saveButton();
		
				}
			
			@Then("Message {string} should be diplayed")
			public void textMsg(String expected) {
			String actual =	homePage.textMsgWeb();
			Assert.assertTrue(actual.contains(expected));
				
			}
	
			
			//---------------------------------------------------CHOOSE FILE-------------------------------------------------------------
			
			
			@When("User clicks on choose file and selects a file")
			public void user_clicks_on_choose_file_and_selects_a_file() {
			    homePage.chooseFilePng();
			}
	
			@Then("That file should be selected")
			public void that_file_should_be_selected() {
			    
			}
	
	
			
			
	//-------------------------------------------------------ADDING COURSE DETAILS-------------------------------------------------------------------------
	
			
			
			@When("User enters course Name {string} in Course name field")
			public void user_enters_course_name_in_course_name_field(String cname) {
			    homePage.enterCourseName(cname);
			}
	
			@When("User enters description {string} in description field")
			public void user_enters_description_in_description_field(String desc) {
				homePage.descAddNewCourse(desc);
			    
			}
	
			@When("User enters instructor {string} in instructor field")
			public void user_enters_instructor_in_instructor_field(String instru) {
				homePage.instruct(instru);
			    
			}
	
			@When("User enters price {int} in price field")
			public void user_enters_price_in_price_field(Integer price) {
			    homePage.price(price);;
			}
	
			@When("User selects date in starts from field")
			public void user_selects_date_in_starts_from_field() {
				homePage.sDate();
			    
			}
	
			@When("User selects date in ends on field")
			public void user_selects_date_in_ends_on_field() {
				homePage.eDate();
			    
			}
	
			@When("User does not check the Permanent checkbox")
			public void user_does_not_check_the_checkbox() {
			    homePage.checkbox();
			}
	
			@When("User selects the category in category field")
			public void user_selects_the_category_in_category_field(DataTable dataTable) {
				homePage.categoryList();
				List<String> data = dataTable.asList();
				for (String e : data)
				{
				System.out.println(e);
			//	homePage.categoryList().add(3, e);
				homePage.categoryList();;
				}
			    
			}
	
			@When("Click on Save Button")
			public void click_on_save_button() {
				homePage.saveButton();
			    
			}
	
			@Then("course {string} has been successfully added")
			public void courseVerification(String course) {
				String actual = homePage.getCourseName();
	//			
			assertEquals(course, actual);
			System.out.println("Verified");
			
			assertTrue("course present",homePage.isCoursePresent(course));
			}
	
	}
