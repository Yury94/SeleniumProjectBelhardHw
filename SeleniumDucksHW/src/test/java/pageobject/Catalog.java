package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Catalog {

    private By productLocator = By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']");

    private WebDriver driver;

    public Catalog(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseProduct() {
        driver.findElement(productLocator).click();
    }
}
