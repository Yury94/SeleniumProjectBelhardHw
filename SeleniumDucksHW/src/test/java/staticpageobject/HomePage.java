package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private static By productLocator = By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']");
    private static By errorMessageLocator = By.xpath("//*[@class='notice errors']");
    private static By successMessageLocator = By.xpath("//*[@class='notice success']");

    public static void chooseProduct(WebDriver driver) {
        driver.findElement(productLocator).click();
    }

    public static String getErrorMessageText (WebDriver driver) {
        return driver.findElement(errorMessageLocator).getText();
    }
    public static String getColorErrorMessage (WebDriver driver) {
        return driver.findElement(errorMessageLocator).getCssValue("background-color");
    }

    public static String getCorrectMessageText (WebDriver driver) {
        return driver.findElement(successMessageLocator).getText();
    }
    public static String getColorCorrectMessage (WebDriver driver) {
        return driver.findElement(successMessageLocator).getCssValue("background-color");
    }
}
