package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private static By confirmTextLocator = By.xpath("//*[@id='box-order-success']/h1");
    private static By successMessageDeleteLocator = By.xpath("//em");
    private static By buttonConfirmLocator = By.xpath("//*[@name='confirm_order']");
    private static By buttonRemoveLocator = By.cssSelector("[name='remove_cart_item']");

    public  static String getConfirmText (WebDriver driver) {
        return driver.findElement(confirmTextLocator).getText();
    }
    public  static String getSuccessMessageDeleteText (WebDriver driver) {
        return driver.findElement(successMessageDeleteLocator).getText();
    }

    public static void buttonConfirm (WebDriver driver) {
        driver.findElement(buttonConfirmLocator).click();
    }
    public static void buttonRemove (WebDriver driver) {
        driver.findElement(buttonRemoveLocator).click();
    }

}
