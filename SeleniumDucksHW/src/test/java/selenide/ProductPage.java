package selenide;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public static void buttonAddToCard() {
        $(By.cssSelector("button[value='Add To Cart']")).click();
    }

    public static void buttonBasket() {
        $(By.xpath("//*[@id='cart']/a[@class='link']")).click();
    }

    public static void selectButton() {
        Select select = new Select($(By.cssSelector("[name='options[Size]']")));
        select.selectByValue("Small");//выбираем нужный нам селект
    }
    public static void validateCatalogPage(String expectedStatusDuck, String expectedTitleCatalog){
        Configuration.assertionMode = AssertionMode.SOFT;
        $(By.cssSelector("[class='main-image fancybox zoomable shadow']")).shouldHave(text(expectedStatusDuck));
        $(By.xpath("//*[@id='box-similar-products']/h3")).shouldHave(text(expectedTitleCatalog));
    }
}
