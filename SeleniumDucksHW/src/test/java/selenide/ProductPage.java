package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
@Epic("Selenium training")
@Feature("Rubber ducks")
public class ProductPage {

    public static void clickAddToCardButton() {
        $(By.cssSelector("button[value='Add To Cart']")).click();
    }

    public static void clickBasketButton() {
        $(By.xpath("//*[@id='cart']/a[@class='link']")).click();
    }

    public static void selectButton(String selectValue) {
        Select select = new Select($(By.cssSelector("[name='options[Size]']")));
        select.selectByValue(selectValue);//выбираем нужный нам селект
    }
    public static void validateCatalogPage(String expectedStatusDuck, String expectedTitleCatalog){
        Configuration.assertionMode = AssertionMode.SOFT;
        $(By.cssSelector("[class='main-image fancybox zoomable shadow']")).shouldHave(text(expectedStatusDuck));
        $(By.xpath("//*[@id='box-similar-products']/h3")).shouldHave(text(expectedTitleCatalog));
    }
}
