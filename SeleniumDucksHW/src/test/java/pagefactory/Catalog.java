package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Catalog {
    @FindBy(css = "[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']")
    private WebElement productLocator;

    public void chooseProduct() {
        productLocator.click();
    }
}
