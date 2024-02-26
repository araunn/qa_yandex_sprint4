package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageQuestionAbout {
	private WebDriver driver;

	 public MainPageQuestionAbout (WebDriver driver) {
		this.driver = driver;
	}
	 
	  public void clickButton(By question) {
	        driver.findElement(question).click();
	    }
	  
	  public String getTextAnswer(By answer) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       return driver.findElement(answer).getText();
	    }
}
