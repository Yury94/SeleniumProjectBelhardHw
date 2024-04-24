package selenide;

import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Listeners({SoftAsserts.class})
public class SelenideRubberDucksHW15Test extends TestBase {

    @Test
    public void myLoginDuckNegativeCase() {
        String ExpectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin("skachkov11@gmail.com", "qwerty12");
        HomePage.validateErrorMessage(ExpectedErrorMessageText, LIGHT_PINK);
        System.out.println("Page of profile isn't opened after tap on Login button. ");
    }

    @Test
    public void myLoginDuckPositiveCase() {
        String ExpectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.validateCorrectMessage(ExpectedCorrectMessageText, LIGHT_GREEN);
        System.out.println("Page of profile is opened correctly!");
    }

    @Test
    public void myCatalogDuck() {
        String ExpectedNameOfTitleCatalog = "Similar Products";//задаем ожидаемую переменную для сравнения
        String ExpectedStatusSale = "SALE";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//нажимаем на товар в каталоге
        ProductPage.validateCatalogPage(ExpectedStatusSale, ExpectedNameOfTitleCatalog);
        System.out.println("Status is correct. Name of titles catalog is displayed correctly.");
    }

    @Test
    public void myBasketConfirmOrder() {
        String ExpectedConfirmText = "Your order is successfully completed!";
        LoginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//выбираем нужный нам продукт
        ProductPage.selectButton();//выбираем нужный нам селект
        ProductPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'
        $("span.quantity").shouldHave(text("1"));//задаем Явное ожидание

        ProductPage.buttonBasket();//нажимаем на корзину
        BasketPage.clickConfirmButton();//нажимаем на кнопку Confirm
        $(By.xpath("//*[@id='box-order-success']/h1")).shouldHave(text(ExpectedConfirmText));
        System.out.println("Order is confirmed");
    }

    @Test
    public void myBasketDeleteOrder() {
        String ExpectedSuccessMessageDelete = "There are no items in your cart.";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//выбираем нужный нам продукт
        ProductPage.selectButton();//выбираем нужный нам селект
        ProductPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'
        $("span.quantity").shouldHave(text("1"));//задаем Явное ожидание

        ProductPage.buttonBasket();//нажимаем на корзину
        BasketPage.clickRemoveButton();//нажимаем на кнопку Remove
        $(By.xpath("//em")).shouldHave(text(ExpectedSuccessMessageDelete));
        System.out.println("Orders was delete successfully from Basket.");
    }
}
