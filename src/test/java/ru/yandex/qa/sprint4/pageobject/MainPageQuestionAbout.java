package ru.yandex.qa.sprint4.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageQuestionAbout {
	private WebDriver driver;
	private By cookiesButton = By.id("rcc-confirm-button");

	 public MainPageQuestionAbout (WebDriver driver) {
		this.driver = driver;
	}
	 
	  public void aceptCookie () {
	    	driver.findElement(cookiesButton).click();
	    }
	 
	  public void clickButton(By question) {
	        driver.findElement(question).click();
	    }
	  
	  public String getTextAnswer(By answer) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       return driver.findElement(answer).getText();
	    }
}
