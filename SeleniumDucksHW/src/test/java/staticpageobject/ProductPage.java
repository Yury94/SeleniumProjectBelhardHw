package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private static By nameOfStatusDuckLocator = By.cssSelector("[class='main-image fancybox zoomable shadow']");
    private static By nameOfTitleCatalogLocator = By.xpath("//*[@id='box-similar-products']/h3");
    private static By buttonAddToCardLocator = By.cssSelector("button[value='Add To Cart']");
    private static By buttonBasketLocator = By.xpath("//*[@id='cart']/a[@class='link']");
    private static By buttonSelectLocator = By.cssSelector("[name='options[Size]']");

    public  static String getNameOfStatusDuckText (WebDriver driver) {
           return driver.findElement(nameOfStatusDuckLocator).getText();
    }
    public static String getNameOfTitleCatalogText (WebDriver driver) {
        return driver.findElement(nameOfTitleCatalogLocator).getText();
    }

    public static void buttonAddToCard (WebDriver driver) {
        driver.findElement(buttonAddToCardLocator).click();
    }
    public static void buttonBasket (WebDriver driver) {
        driver.findElement(buttonBasketLocator).click();
    }
    public static void selectButton (WebDriver driver) {
        Select select = new Select(driver.findElement(buttonSelectLocator));
        select.selectByValue("Small");//выбираем нужный нам селект
    }
}
