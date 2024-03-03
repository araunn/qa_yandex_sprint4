package ru.yandex.qa.pageobject.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonOrder {
    private WebDriver driver;
	private By cookiesButton = By.id("rcc-confirm-button");
    private By orderButtonUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    private By orderButtonDown = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By telefonField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By metroMenu = By.className("select-search");
    private By metroMenuSelected = By.className("select-search__select");
    private By nextPageButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By dateField = By.className("react-datepicker__input-container");
    private By dateSelected = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--030 react-datepicker__day--weekend']");
    private By timeRentField = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    private By timeRentSelected = By.className("Dropdown-option");
    private By colourField = By.className("Checkbox_Input__14A2w");
    private By commetField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By yesWontOrderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text() = 'Да')]");
    private By orderComplitWindow = By.className("Order_ModalHeader__3FDaJ");

    public ButtonOrder(WebDriver driver) {
		this.driver = driver;
	}
    
    public void startOrderWithUpButton () {
    	driver.findElement(orderButtonUp).click();
    }
    
    public void startOrderWithDownButton () {
    	driver.findElement(orderButtonDown).click();
    }
    
    public void aceptCookie () {
    	driver.findElement(cookiesButton).click();
    }
    
    public void forWhyWindow () {
    	driver.findElement(nameField).sendKeys(TestFieldData.NAME);
    	driver.findElement(surnameField).sendKeys(TestFieldData.SURNAME);
    	driver.findElement(adressField).sendKeys(TestFieldData.ADRESS);
    	driver.findElement(metroMenu).click();
    	driver.findElement(metroMenuSelected).click();
    	driver.findElement(telefonField).sendKeys(TestFieldData.TELEPHONE);
    	driver.findElement(nextPageButton).click();
    }
    
    public void forRentWindow () {
    	driver.findElement(dateField).click();
    	driver.findElement(dateSelected).click();
    	driver.findElement(timeRentField).click();
    	driver.findElement(timeRentSelected).click();
    	driver.findElement(colourField).click();
    	driver.findElement(commetField).sendKeys(TestFieldData.COMMENT);
    	driver.findElement(orderButton).click();
    }
    
    public void youWishOrderWindow() {
    	driver.findElement(yesWontOrderButton).click();
    }
    
    public String getTextOrderComplit () {
    	return driver.findElement(orderComplitWindow).getText();
    }
    
}
