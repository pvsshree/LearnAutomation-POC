package com.pages;

import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private Actions actions;
	WebDriverWait wait;
	
	//By Locators
//	private By home = By.xpath("//a[@href='/']");
	private By hoverOnManage = By.xpath("//*[normalize-space()='Manage']");
	private By dropDownList = By.xpath("//div[@class='nav-menu-item-hover-div']");
	
	private By manageCourse = By.xpath("//a[@href='/course/manage']");
	private By addNewCourse = By.xpath("//button[.//img[@alt='add']]");
	private By popUpForAddNew = By.xpath("//div[@class='modal-dialog']");
	private By saveBtn = By.xpath("//button[@class='action-btn']");
	private By textMsgWeb = By.xpath("//h2[@class='errorMessage']");
	private By chooseFile = By.xpath("//input[@id='thumbnail']");
	
//----------------------------------------------Add New course details locators-------------------------------------------------
	private By courseName = By.xpath("//input[@id='name']");
    private By description = By.xpath("//textarea[@id='description']");
	private By instruct  = By.xpath("//input[@name='instructorName']");
	private By price = By.xpath("//input[@name='price']");
	private By startDate = By.xpath("//input[@name='startDate']");
	private By endDate = By.xpath("//input[@name='endDate']");
	private By checkbox = By.xpath("//input[@id='isPermanent']");
	private By category = By.xpath("//button[.//img[@alt='select category']]");
	private By seleniumBtn = By.xpath(("//button[text()='Selenium']"));
	
	
public HomePage(WebDriver driver) 
{
	this.driver=driver;
	this.actions = new Actions(driver); 
	 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
}

//Actions

public void typeSlowly(WebElement element, String text) {
    for (char ch : text.toCharArray()) {
        element.sendKeys(String.valueOf(ch));
        try {
            Thread.sleep(200); // delay between each character
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public String getTitleAsHomePage() {
	return driver.getTitle();
}



	public void hoverOnManage() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement hoverList = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(hoverOnManage)
	    );

		actions.moveToElement(hoverList).perform();
		}

	public List<String> getDropdownList() 
	{
		List<String> dropdownOfManageArray = new ArrayList<>();
		
		// Step 1: Hover first
	    hoverOnManage();
	    
	 // Step 2: Apply wait AFTER hover
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> dropDownOfManage  = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropDownList));
		
		for(WebElement e : dropDownOfManage)
		{
			String text = e.getText();
			System.out.println(text);
			dropdownOfManageArray.add(text);
		}
		return dropdownOfManageArray;
	}
	
	
	
public void clickOnManageCourses() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    WebElement clickManageCourse = wait.until(
        ExpectedConditions.visibilityOfElementLocated(manageCourse)
    );
	
	clickManageCourse.click();
	
//	driver.findElement(manageCourse).click();
	
}
	
	public void addNewCourse() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(addNewCourse));
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addNewCourse));
		addButton.click();
		//driver.findElement(addNewCourse).click();
	}
	
	public void popUpForAddNew() {
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(popUpForAddNew));
	 driver.findElement(popUpForAddNew);
	}
	
	
	public void saveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		save.click();
	}
	
	public String textMsgWeb() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(textMsgWeb));
	return driver.findElement(textMsgWeb).getText();
	}
	
public void chooseFilePng() {
	
	driver.findElement(chooseFile).sendKeys("C:\\Users\\vsoma\\OneDrive\\Desktop\\Screenshot.png");
}


//----------------------------------------------Add New course details methods------------------------------------------------

public void enterCourseName(String cname) 
{
	WebElement enter_Course_name = driver.findElement(courseName);
	enter_Course_name.clear();
	enter_Course_name.sendKeys(cname);
	
}

public String getCourseName() {
	return driver.findElement(courseName).getAttribute("value");
}

public void descAddNewCourse(String desc) {
	WebElement desc_Add_New_Course = driver.findElement(description);
	System.out.println(desc_Add_New_Course.getAttribute("outerhtml"));
	System.out.println(desc_Add_New_Course.getAttribute("id"));
	System.out.println(desc_Add_New_Course.getAttribute("innerhtml"));
	
	System.out.println(desc_Add_New_Course);
	desc_Add_New_Course.clear();
	desc_Add_New_Course.sendKeys(desc);
}


public void instruct(String inst) 
{
	WebElement instructor = driver.findElement(instruct);
	instructor.clear();
	instructor.sendKeys(inst);
	
}

public void price(int pri) {
	 WebElement price_Add = driver.findElement(price);
	 price_Add.clear();
	 price_Add.sendKeys(String.valueOf(pri));
}

public void sDate() {
	WebElement sDate = driver.findElement(startDate);
			sDate.click();
	sDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	sDate.sendKeys(Keys.DELETE);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable
			(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='20' and not(contains(@class," + "'outside-month'))]")));
	dayElement.click();
//	sDate.sendKeys(start);
	
	
}

public void eDate(String end)
{
	WebElement eDate = wait.until(ExpectedConditions.elementToBeClickable(endDate));
	//WebElement eDate = driver.findElement(endDate);
eDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
eDate.sendKeys(Keys.DELETE);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

eDate.sendKeys(end);
	}

//No unclick is there so using negative approach
public void checkbox() {
	WebElement check = driver.findElement(checkbox);
	if(check.isSelected())
		
	{
		check.click();
	}
}


public void categoryList() {
/*	//List<String> catList = new ArrayList<>();
	List<WebElement> categories = driver.findElements(category);
	
	for(WebElement cat : categories)
	{
		if(cat.getText().equalsIgnoreCase("Selenium")) 
		{cat.click();
		
		break;
		}
	}

//	return catList;*/
 driver.findElement(category).click();
 driver.findElement(seleniumBtn).click();
	
	
	
}


public void seleniumSelect() {
	WebElement element = driver.findElement(seleniumBtn);
}















}
