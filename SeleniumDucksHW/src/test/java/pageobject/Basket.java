package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basket {

    private By confirmTextLocator = By.xpath("//*[@id='box-order-success']/h1");
    private By successMessageDeleteLocator = By.xpath("//em");
    private By buttonConfirmLocator = By.xpath("//*[@name='confirm_order']");
    private By buttonRemoveLocator = By.cssSelector("[name='remove_cart_item']");

    private final WebDriver driver;

    public Basket(WebDriver driver) {
        this.driver = driver;
    }
    public  String getConfirmText () {
        return driver.findElement(confirmTextLocator).getText();
    }
    public  String getSuccessMessageDeleteText () {
        return driver.findElement(successMessageDeleteLocator).getText();
    }

    public void buttonConfirm () {
        driver.findElement(buttonConfirmLocator).click();
    }
    public void buttonRemove () {
        driver.findElement(buttonRemoveLocator).click();
    }

}
