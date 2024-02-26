package qa_yandex_sprint4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.MainPageQuestionAbout;

@RunWith(Parameterized.class)
public class qa_yandex_test_questionsAbout {
	private WebDriver driver;
	private String siteAdress = "https://qa-scooter.praktikum-services.ru/";
	private By cookiesButton = By.id("rcc-confirm-button");
	private final By question;
	private final By answer;
	private final String massage;

	
	public qa_yandex_test_questionsAbout(By question, By answer, String massage) {
		this.question = question;
		this.answer = answer;
		this.massage = massage;
	}
	@After
	public void teardown() {
	    System.out.println("____quit_____");
	    driver.quit();
	}

			
		@Parameterized.Parameters
		public static Object[][] getQuestionAnswer() {
		   return new Object[][] {
		           {By.id("accordion__heading-0"),By.xpath(".//div[@id='accordion__panel-0']/p"),"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
		           {By.id("accordion__heading-1"),By.xpath(".//div[@id='accordion__panel-1']/p"),"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
		           {By.id("accordion__heading-2"),By.xpath(".//div[@id='accordion__panel-2']/p"),"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
		           {By.id("accordion__heading-3"),By.xpath(".//div[@id='accordion__panel-3']/p"),"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
		           {By.id("accordion__heading-4"),By.xpath(".//div[@id='accordion__panel-4']/p"),"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
		           {By.id("accordion__heading-5"),By.xpath(".//div[@id='accordion__panel-5']/p"),"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
		           {By.id("accordion__heading-6"),By.xpath(".//div[@id='accordion__panel-6']/p"),"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
		           {By.id("accordion__heading-7"),By.xpath(".//div[@id='accordion__panel-7']/p"),"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
		   };
		}
		
	// тестирование раздела вопросов о важном Crome
		@Test
		public void testQuestionsAboutCrome() {
			driver = new ChromeDriver();
			driver.get(siteAdress);
			driver.findElement(cookiesButton).click();
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
			page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
		
	// тестирование раздела вопросов о важном FireFox	
		@Test
		public void testQuestionsAboutFireFox() {
			driver = new FirefoxDriver();
			driver.get(siteAdress);
			driver.findElement(cookiesButton).click();
			MainPageQuestionAbout page = new MainPageQuestionAbout(driver);
            page.clickButton(question);
			assertEquals(massage,page.getTextAnswer(answer));
		}
}
