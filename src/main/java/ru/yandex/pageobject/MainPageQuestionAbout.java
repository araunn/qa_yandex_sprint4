package ru.yandex.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageQuestionAbout {
	private WebDriver driver;
	private By cookiesButton = By.id("rcc-confirm-button");
	public static final String SITE_ADRESS = "https://qa-scooter.praktikum-services.ru/";

	public static By LOCATOR_QUESTION_1 = By.id("accordion__heading-0");
	public static By LOCATOR_QUESTION_2 = By.id("accordion__heading-1");
	public static By LOCATOR_QUESTION_3 = By.id("accordion__heading-2");
	public static By LOCATOR_QUESTION_4 = By.id("accordion__heading-3");
	public static By LOCATOR_QUESTION_5 = By.id("accordion__heading-4");
	public static By LOCATOR_QUESTION_6 = By.id("accordion__heading-5");
	public static By LOCATOR_QUESTION_7 = By.id("accordion__heading-6");
	public static By LOCATOR_QUESTION_8 = By.id("accordion__heading-7");

	public static By LOCATOR_ANSWER_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
	public static By LOCATOR_ANSWER_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
	public static By LOCATOR_ANSWER_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
	public static By LOCATOR_ANSWER_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
	public static By LOCATOR_ANSWER_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
	public static By LOCATOR_ANSWER_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
	public static By LOCATOR_ANSWER_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
	public static By LOCATOR_ANSWER_8 = By.xpath(".//div[@id='accordion__panel-7']/p");
	
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
