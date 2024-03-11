package ru.yandex.qa.sprint4;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.pageobject.ButtonOrder;

public class TestOrderSamokat {
	private WebDriver driver;
	
	@After
	public void teardown() {
	    driver.quit();
	}
	
	//Тест заказа при нажатии верхней кнопки "Заказать" Crome
	@Test
	public void testUpButtonOrderCrome() {
		driver = new ChromeDriver();
		driver.get(ButtonOrder.SITE_ADRESS);
		ButtonOrder testWithUpButtonOrder = new ButtonOrder(driver);
		testWithUpButtonOrder.aceptCookie();
		testWithUpButtonOrder.startOrderWithUpButton();
		testWithUpButtonOrder.forWhyWindow();
	    testWithUpButtonOrder.forRentWindow();
	    testWithUpButtonOrder.youWishOrderWindow();
	    assertEquals (ButtonOrder.ORDER_COMPLITE_MASSAGE,
	    		testWithUpButtonOrder.getTextOrderComplit().substring(0,ButtonOrder.ORDER_COMPLITE_MASSAGE.length()));
	}
	
	//Тест заказа при нажатии нижней кнопки "Заказать" Crome
	@Test
	public void testDownButtonOrderCrome() {
		driver = new ChromeDriver();
		driver.get(ButtonOrder.SITE_ADRESS);
		ButtonOrder testWithDownButtonOrder = new ButtonOrder(driver);
		testWithDownButtonOrder.aceptCookie();
		testWithDownButtonOrder.startOrderWithDownButton();;
		testWithDownButtonOrder.forWhyWindow();
	    testWithDownButtonOrder.forRentWindow();
	    testWithDownButtonOrder.youWishOrderWindow();
	    assertEquals (ButtonOrder.ORDER_COMPLITE_MASSAGE,
	    		testWithDownButtonOrder.getTextOrderComplit().substring(0,ButtonOrder.ORDER_COMPLITE_MASSAGE.length()));
	} 
	
	//Тест заказа при нажатии верхней кнопки "Заказать" FireFox
	@Test
	public void testUpButtonOrderFireFox() {
		driver = new FirefoxDriver();
		driver.get(ButtonOrder.SITE_ADRESS);
		ButtonOrder testWithUpButtonOrder = new ButtonOrder(driver);
		testWithUpButtonOrder.aceptCookie();
		testWithUpButtonOrder.startOrderWithUpButton();
		testWithUpButtonOrder.forWhyWindow();
	    testWithUpButtonOrder.forRentWindow(); 
	    testWithUpButtonOrder.youWishOrderWindow();
	    assertEquals (ButtonOrder.ORDER_COMPLITE_MASSAGE,
	    		testWithUpButtonOrder.getTextOrderComplit().substring(0,ButtonOrder.ORDER_COMPLITE_MASSAGE.length()));
	}

	//Тест заказа при нажатии нижней кнопки "Заказать" fireFox
	@Test
	public void testDownButtonOrderFireFox() {
		driver = new FirefoxDriver();
		driver.get(ButtonOrder.SITE_ADRESS);
		ButtonOrder testWithDownButtonOrder = new ButtonOrder(driver);
		testWithDownButtonOrder.aceptCookie();
		testWithDownButtonOrder.startOrderWithDownButton();;
		testWithDownButtonOrder.forWhyWindow();
	    testWithDownButtonOrder.forRentWindow();
	    testWithDownButtonOrder.youWishOrderWindow();
	    assertEquals (ButtonOrder.ORDER_COMPLITE_MASSAGE,
	    		testWithDownButtonOrder.getTextOrderComplit().substring(0,ButtonOrder.ORDER_COMPLITE_MASSAGE.length()));
	}   
}
