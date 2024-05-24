package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[@class='notice errors']")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@class='notice success']")
    private  WebElement successMessage;


    public  String getErrorMessageText () {
        return errorMessage.getText();
    }
    public  String getColorErrorMessage () {
        return errorMessage.getCssValue("background-color");
    }

    public  String getCorrectMessageText () {
        return successMessage.getText();
    }
    public  String getColorCorrectMessage () {
        return successMessage.getCssValue("background-color");
    }
}
