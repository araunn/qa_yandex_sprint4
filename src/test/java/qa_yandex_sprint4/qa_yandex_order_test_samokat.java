package qa_yandex_sprint4;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.ButtonOrder;

public class qa_yandex_order_test_samokat {
	private WebDriver driver;
	private String siteAdress = "https://qa-scooter.praktikum-services.ru/";
	private By cookiesButton = By.id("rcc-confirm-button");
    private By orderButtonUp = By.xpath(".//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    private By orderButtonDown = By.xpath(".//*[@id=\'root\']/div/div/div[4]/div[2]/div[5]/button");
    private By nameField = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[1]/input");
    private By surnameField = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[2]/input");
    private By adressField = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[3]/input");
    private By telefonField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private By metroMenu = By.className("select-search");
    private By metroMenuSelected = By.className("select-search__select");
    private By nextPageButton = By.xpath(".//*[@id=\'root\']/div/div[2]/div[3]/button");
    private By dateField = By.className("react-datepicker__input-container");
    private By dateSelected = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]");
    private By timeRentField = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[2]");
    private By timeRentSelected = By.className("Dropdown-option");
    private By colourField = By.className("Checkbox_Input__14A2w");
    private By commetField = By.xpath(".//*[@id=\'root\']/div/div[2]/div[2]/div[4]/input");
    private By orderButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button[2]");
    private By yesWontOrderButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    private By orderComplitWindow = By.className("Order_ModalHeader__3FDaJ");
    private String message = "Заказ оформлен";
	
	@After
	public void teardown() {
	    System.out.println("____quit_____");
	    driver.quit();
	}
	
	//Тест заказа при нажатии верхней кнопки "Заказать" Crome
	@Test
	public void testUpButtonOrderCrome() {
		driver = new ChromeDriver();
		driver.get(siteAdress);
		driver.findElement(cookiesButton).click();
		ButtonOrder testWithUpButtonOrder = new ButtonOrder(driver);
		testWithUpButtonOrder.startOrder(orderButtonUp);
		testWithUpButtonOrder.forWhyWindow(nameField, surnameField, adressField, metroMenu,metroMenuSelected, telefonField, nextPageButton);
	    testWithUpButtonOrder.forRentWindow(dateField,dateSelected, timeRentField, timeRentSelected, colourField, commetField, orderButton);
	    testWithUpButtonOrder.startOrder(yesWontOrderButton);
	    assertEquals (message,testWithUpButtonOrder.getTextOrderComplit(orderComplitWindow).substring(0,14));
	}
	
	//Тест заказа при нажатии нижней кнопки "Заказать" Crome
	@Test
	public void testDownButtonOrderCrome() {
		driver = new ChromeDriver();
		driver.get(siteAdress);
		driver.findElement(cookiesButton).click();
		ButtonOrder testWithDownButtonOrder = new ButtonOrder(driver);
		testWithDownButtonOrder.startOrder(orderButtonDown);
		testWithDownButtonOrder.forWhyWindow(nameField, surnameField, adressField, metroMenu,metroMenuSelected, telefonField, nextPageButton);
	    testWithDownButtonOrder.forRentWindow(dateField,dateSelected, timeRentField, timeRentSelected, colourField, commetField, orderButton);
	    testWithDownButtonOrder.startOrder(yesWontOrderButton);
	    assertEquals (message,testWithDownButtonOrder.getTextOrderComplit(orderComplitWindow).substring(0,14));
	} 
	
	//Тест заказа при нажатии верхней кнопки "Заказать" FireFox
	@Test
	public void testUpButtonOrderFireFox() {
		driver = new FirefoxDriver();
		driver.get(siteAdress);
		driver.findElement(cookiesButton).click();
		ButtonOrder testWithUpButtonOrder = new ButtonOrder(driver);
		testWithUpButtonOrder.startOrder(orderButtonUp);
		testWithUpButtonOrder.forWhyWindow(nameField, surnameField, adressField, metroMenu,metroMenuSelected, telefonField, nextPageButton);
	    testWithUpButtonOrder.forRentWindow(dateField,dateSelected, timeRentField, timeRentSelected, colourField, commetField, orderButton);
	    testWithUpButtonOrder.startOrder(yesWontOrderButton);
	    assertEquals (message,testWithUpButtonOrder.getTextOrderComplit(orderComplitWindow).substring(0,14));
	}

	//Тест заказа при нажатии нижней кнопки "Заказать" fireFox
	@Test
	public void testDownButtonOrderFireFox() {
		driver = new FirefoxDriver();
		driver.get(siteAdress);
		driver.findElement(cookiesButton).click();
		ButtonOrder testWithDownButtonOrder = new ButtonOrder(driver);
		testWithDownButtonOrder.startOrder(orderButtonDown);
		testWithDownButtonOrder.forWhyWindow(nameField, surnameField, adressField, metroMenu,metroMenuSelected, telefonField, nextPageButton);
	    testWithDownButtonOrder.forRentWindow(dateField,dateSelected, timeRentField, timeRentSelected, colourField, commetField, orderButton);
	    testWithDownButtonOrder.startOrder(yesWontOrderButton);
	    assertEquals (message,testWithDownButtonOrder.getTextOrderComplit(orderComplitWindow).substring(0,14));
	} 
}
