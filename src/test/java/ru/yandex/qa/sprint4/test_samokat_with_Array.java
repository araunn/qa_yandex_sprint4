package ru.yandex.qa.sprint4;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_samokat_with_Array {
private WebDriver driver;
// не смог параметризировать тесты, поэтому такой кастыль
private By [] questiontestArray = {By.id("accordion__heading-0"),
		                           By.id("accordion__heading-1"),
		                           By.id("accordion__heading-2"),
		                           By.id("accordion__heading-3"),
		                           By.id("accordion__heading-4"),
		                           By.id("accordion__heading-5"),
		                           By.id("accordion__heading-6"),
		                           By.id("accordion__heading-7")};
private By [] answertestArray = {By.xpath(".//div[@id='accordion__panel-0']/p"),
		                         By.xpath(".//div[@id='accordion__panel-1']/p"),
		                         By.xpath(".//div[@id='accordion__panel-2']/p"),
		                         By.xpath(".//div[@id='accordion__panel-3']/p"),
		                         By.xpath(".//div[@id='accordion__panel-4']/p"),
		                         By.xpath(".//div[@id='accordion__panel-5']/p"),
		                         By.xpath(".//div[@id='accordion__panel-6']/p"),
		                         By.xpath(".//div[@id='accordion__panel-7']/p")};
private String [] messageTestArray = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
		"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
		"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
		"Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
		"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
		"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
		"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
		"Да, обязательно. Всем самокатов! И Москве, и Московской области."};

// создаем экземпляр драйвера, открываем страницу, принимаем куки
@Before
public void createDriver() {
	driver = new ChromeDriver();
	driver.get("https://qa-scooter.praktikum-services.ru/");
	driver.findElement(By.id("rcc-confirm-button")).click();
}
@After
public void teardown() {
    System.out.println("____quit_____");
    driver.quit();
}


class MainPageQuestionsAbout{
	private WebDriver driver;
	private By question;
	private By answer;

	 public MainPageQuestionsAbout(WebDriver driver) {
		this.driver = driver;
		this.question = question;
		this.answer=answer;
	}
	  public void clickButton(By question) {
	        driver.findElement(question).click();
	    }
	  public String getTextAnswer(By answer) {
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       return driver.findElement(answer).getText();
	    }
} 

@Test
public void test() {
	MainPageQuestionsAbout page= new MainPageQuestionsAbout(driver);
	for (int i=0; i<= questiontestArray.length-1; i++) {
	page.clickButton(questiontestArray[i]);
	assertEquals(messageTestArray[i], page.getTextAnswer(answertestArray[i]));
	}
}
}
