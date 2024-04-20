package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private  By errorMessageLocator = By.xpath("//*[@class='notice errors']");
    private  By successMessageLocator = By.xpath("//*[@class='notice success']");

    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public  String getErrorMessageText () {
        return driver.findElement(errorMessageLocator).getText();
    }
    public  String getColorErrorMessage () {
        return driver.findElement(errorMessageLocator).getCssValue("background-color");
    }

    public  String getCorrectMessageText () {
        return driver.findElement(successMessageLocator).getText();
    }
    public  String getColorCorrectMessage () {
        return driver.findElement(successMessageLocator).getCssValue("background-color");
    }

}
