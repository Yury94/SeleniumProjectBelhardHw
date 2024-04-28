package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
@Epic("Selenium training")
@Feature("Rubber ducks")
public class HomePage {
    public static void chooseProductFromCatalogAfterSuccessLogin() {
        $(By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']")).click();
    }
    public static void validateErrorMessage (String expectedErrorText, String bgColor) {
        Configuration.assertionMode = AssertionMode.SOFT;
        $(By.xpath("//*[@class='notice errors']")).shouldHave(text(expectedErrorText));
        $(By.xpath("//*[@class='notice errors']")).shouldHave(cssValue("background-color", bgColor));
    }
    public static void validateCorrectMessage (String expectedCorrectText, String bgColor) {
        Configuration.assertionMode = AssertionMode.SOFT;
        $(By.xpath("//*[@class='notice success']")).shouldHave(text(expectedCorrectText));
        $(By.xpath("//*[@class='notice success']")).shouldHave(cssValue("background-color", bgColor));
    }

}
