package PageObject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonOrder {
    private WebDriver driver;

    public ButtonOrder(WebDriver driver) {
		this.driver = driver;
	}
    
    public void startOrder (By orderButtonUp) {
    	driver.findElement(orderButtonUp).click();
    }
    
    public void forWhyWindow (By nameField,By surnameField,By adressField,By metroMenu,By metroMenuSelected, By telefonField,By nextPageButton) {
    	driver.findElement(nameField).sendKeys("иван");
    	driver.findElement(surnameField).sendKeys("иванов");
    	driver.findElement(adressField).sendKeys("ул Усвчева5");
    	driver.findElement(metroMenu).click();
    	driver.findElement(metroMenuSelected).click();
    	driver.findElement(telefonField).sendKeys("89037854144");
    	driver.findElement(nextPageButton).click();
    }
    
    public void forRentWindow (By dateField,By dateSelected,By timeRentField,By timeRentSelected,By colourField,By commetField,By orderButton) {
    	driver.findElement(dateField).click();
    	driver.findElement(dateSelected).click();
    	driver.findElement(timeRentField).click();
    	driver.findElement(timeRentSelected).click();
    	driver.findElement(colourField).click();
    	driver.findElement(commetField).sendKeys("Мой комментарий");
    	driver.findElement(orderButton).click();
    }
    
    public void youWishOrderWindow(By yesWontOrderButton) {
    	driver.findElement(yesWontOrderButton).click();
    }
    
    public String getTextOrderComplit (By orderComplitWindow) {
    	return driver.findElement(orderComplitWindow).getText();
    }
    
}
