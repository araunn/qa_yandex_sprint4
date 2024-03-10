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
import ru.yandex.data.AnswerMessageData;
import ru.yandex.pageobject.MainPageQuestionAbout;

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
		           {MainPageQuestionAbout.LOCATOR_QUESTION_1,MainPageQuestionAbout.LOCATOR_ANSWER_1,AnswerMessageData.ANSWER_MESSAGE_1},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_2,MainPageQuestionAbout.LOCATOR_ANSWER_2,AnswerMessageData.ANSWER_MESSAGE_2},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_3,MainPageQuestionAbout.LOCATOR_ANSWER_3,AnswerMessageData.ANSWER_MESSAGE_3},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_4,MainPageQuestionAbout.LOCATOR_ANSWER_4,AnswerMessageData.ANSWER_MESSAGE_4},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_5,MainPageQuestionAbout.LOCATOR_ANSWER_5,AnswerMessageData.ANSWER_MESSAGE_5},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_6,MainPageQuestionAbout.LOCATOR_ANSWER_6,AnswerMessageData.ANSWER_MESSAGE_6},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_7,MainPageQuestionAbout.LOCATOR_ANSWER_7,AnswerMessageData.ANSWER_MESSAGE_7},
		           {MainPageQuestionAbout.LOCATOR_QUESTION_8,MainPageQuestionAbout.LOCATOR_ANSWER_8,AnswerMessageData.ANSWER_MESSAGE_8},
		   };
		}
		
	// тестирование раздела вопросов о важном Crome
		@Test
		public void testQuestionsAboutCrome() {
			driver = new ChromeDriver();
			driver.get(MainPageQuestionAbout.SITE_ADRESS);
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
			page.aceptCookie();
			page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
		
	// тестирование раздела вопросов о важном FireFox	
		@Test
		public void testQuestionsAboutFireFox() {
			driver = new FirefoxDriver();
			driver.get(MainPageQuestionAbout.SITE_ADRESS);
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
			page.aceptCookie();
            page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
}
