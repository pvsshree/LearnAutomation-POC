package com.pages;

import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private Actions actions;
	
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

public HomePage(WebDriver driver) 
{
	this.driver=driver;
	this.actions = new Actions(driver); 
	
}

//Actions

public String getTitleAsHomePage() {
	return driver.getTitle();
}



	public void hoverOnManage() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
	 driver.findElement(popUpForAddNew);
	}
	
	
	public void saveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		save.click();
	}
	
	public String textMsgWeb() {
		return driver.findElement(textMsgWeb).getText();
	}
	
public void chooseFilePng() {
	
	driver.findElement(chooseFile).sendKeys("C:\\Users\\vsoma\\OneDrive\\Desktop\\Screenshot.png");
}

}
