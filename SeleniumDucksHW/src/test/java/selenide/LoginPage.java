package selenide;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Epic("Selenium training")
@Feature("Rubber ducks")
public class LoginPage {
    @Step("Attempt to Login")
    public static void attemptLogin(String username, String password) {
        $(By.name("email")).sendKeys(username);
        $(By.name("password")).sendKeys(password);
        $(By.name("login")).click();
    }
}
