package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static void attemptLogin (String username, String password) {
        $(By.name("email")).sendKeys(username);
        $(By.name("password")).sendKeys(password);
        $(By.name("login")).click();
    }
}
