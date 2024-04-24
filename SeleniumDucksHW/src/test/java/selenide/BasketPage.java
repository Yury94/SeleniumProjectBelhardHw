package selenide;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    public static void clickConfirmButton() {
        $(By.xpath("//*[@name='confirm_order']")).click();
    }

    public static void clickRemoveButton() {
        $(By.cssSelector("[name='remove_cart_item']")).click();
    }

}
