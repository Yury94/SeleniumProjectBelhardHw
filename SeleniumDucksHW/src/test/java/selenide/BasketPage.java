package selenide;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
@Epic("Selenium training")
@Feature("Rubber ducks")
public class BasketPage {

    public static void validateOrderSuccessMessage(String expectedConfirmText){
        $(By.xpath("//*[@id='box-order-success']/h1")).shouldHave(text(expectedConfirmText));
    }

    public static void validateSuccessMessageAfterDelete(String expectedDeleteText){
        $(By.xpath("//em")).shouldHave(text(expectedDeleteText));
    }

    public static void clickConfirmButton() {
        $(By.xpath("//*[@name='confirm_order']")).click();
    }

    public static void clickRemoveButton() {
        $(By.cssSelector("[name='remove_cart_item']")).click();
    }

}
