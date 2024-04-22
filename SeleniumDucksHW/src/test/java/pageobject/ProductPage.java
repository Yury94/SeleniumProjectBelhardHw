package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private By nameOfStatusDuckLocator = By.cssSelector("[class='main-image fancybox zoomable shadow']");
    private By nameOfTitleCatalogLocator = By.xpath("//*[@id='box-similar-products']/h3");
    private By buttonAddToCardLocator = By.cssSelector("button[value='Add To Cart']");
    private By buttonBasketLocator = By.xpath("//*[@id='cart']/a[@class='link']");
    private By buttonSelectLocator = By.cssSelector("[name='options[Size]']");

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public  String getNameOfStatusDuckText () {
        return driver.findElement(nameOfStatusDuckLocator).getText();
    }
    public  String getNameOfTitleCatalogText () {
        return driver.findElement(nameOfTitleCatalogLocator).getText();
    }

    public void buttonAddToCard () {
        driver.findElement(buttonAddToCardLocator).click();
    }
    public void buttonBasket () {
        driver.findElement(buttonBasketLocator).click();
    }
    public void selectButton () {
        Select select = new Select(driver.findElement(buttonSelectLocator));
        select.selectByValue("Small");//выбираем нужный нам селект
    }
}
