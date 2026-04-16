package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnAutomationPage {
	
	private WebDriver driver;
	//Actions actions;
	
	//By locators
	private By email = By.id("email1");
	private By password = By.id("password1");
	private By signInButton = By.className("submit-btn");
	

	
	//Constructor (when constructor is called driver gets initialized)
	public LearnAutomationPage(WebDriver driver)
	{
		this.driver = driver;
		//after driver is initialized we can pass it to actions
	//	this.actions = new Actions(driver); 
	}
	
	
	//Actions
	public String getTitleOfPage()
	{return driver.getTitle();}
	
	
	public void enterUsername(String emailFeatureFile) {
		driver.findElement(email).sendKeys(emailFeatureFile);
	}
	
	public void enterPassword(String pwdFeatureFile) {
		driver.findElement(password).sendKeys(pwdFeatureFile);
	}
	
	
	public void clickOnSignIn() {
		driver.findElement(signInButton).click();
	}
	
	//combine all three in one and created object of next page i.e. cart page
	public HomePage doLogin(String un, String pwd) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(un);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
   //     wait.until(ExpectedConditions.elementToBeClickable
     //   		By homeLink = By.xpath("//a[@class='nav-menu-item' and @href='/']");

  //      wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink));
  //      wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
        		
        		//(By.xpath("//a[@class ='nav-menu-item' and @href='/']")));


		return new HomePage(driver);
		
	}
	
	
	
	
	
	
	
	
	
	

}
