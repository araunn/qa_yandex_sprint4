package ru.yandex.qa.sprint4;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import ru.yandex.qa.sprint4.pageobject.MainPageQuestionAbout;

@RunWith(Parameterized.class)
public class TestSamokatQuestionsAbout {
	private WebDriver driver;
	private final By question;
	private final By answer;
	private final String massage;

	
	public TestSamokatQuestionsAbout(By question, By answer, String massage) {
		this.question = question;
		this.answer = answer;
		this.massage = massage;
	}
	
	@After
	public void teardown() {
	    driver.quit();
	}

			
		@Parameterized.Parameters
		public static Object[][] getQuestionAnswer() {
		   return new Object[][] {
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_1),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_1),LocatorAndTestData.ANSWER_MESSAGE_1},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_2),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_2),LocatorAndTestData.ANSWER_MESSAGE_2},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_3),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_3),LocatorAndTestData.ANSWER_MESSAGE_3},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_4),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_4),LocatorAndTestData.ANSWER_MESSAGE_4},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_5),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_5),LocatorAndTestData.ANSWER_MESSAGE_5},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_6),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_6),LocatorAndTestData.ANSWER_MESSAGE_6},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_7),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_7),LocatorAndTestData.ANSWER_MESSAGE_7},
		           {By.id(LocatorAndTestData.LOCATOR_QUESTION_8),By.xpath(LocatorAndTestData.LOCATOR_ANSWER_8),LocatorAndTestData.ANSWER_MESSAGE_8},
		   };
		}
		
	// тестирование раздела вопросов о важном Crome
		@Test
		public void testQuestionsAboutCrome() {
			driver = new ChromeDriver();
			driver.get(LocatorAndTestData.SITE_ADRESS);
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
			page.aceptCookie();
			page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
		
	// тестирование раздела вопросов о важном FireFox	
		@Test
		public void testQuestionsAboutFireFox() {
			driver = new FirefoxDriver();
			driver.get(LocatorAndTestData.SITE_ADRESS);
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
			page.aceptCookie();
            page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
}
