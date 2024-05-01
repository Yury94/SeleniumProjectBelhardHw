package selenide;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static selenide.LoginPage.attemptLogin;

@Epic("Selenium training")
@Feature("Rubber ducks")
@Listeners({SoftAsserts.class, TestBase.class})
public class SelenideRubberDucksHW15Test extends TestBase {

    @Description("Page of profile isn't opened after tap on Login button.")
    @Story("Login with incorrect credential")
    @Test
    public void myLoginDuckNegativeCase() {
        String expectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения
        attemptLogin("skachkov11@gmail.com", "qwerty12");
        HomePage.validateErrorMessage(expectedErrorMessageText, LIGHT_PINK);
        System.out.println("Page of profile isn't opened after tap on Login button.");
    }

    @Description("Page of profile is opened correctly!")
    @Story("Login with correct credential")
    @Test
    public void myLoginDuckPositiveCase() {
        String expectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.validateCorrectMessage(expectedCorrectMessageText, LIGHT_GREEN);
        System.out.println("Page of profile is opened correctly!");
    }

    @Description("Status is correct. Name of titles catalog is displayed correctly.")
    @Story("Choose any product from catalog")
    @Test
    public void myCatalogDuck() {
        String expectedNameOfTitleCatalog = "Similar Products";//задаем ожидаемую переменную для сравнения
        String expectedStatusSale = "SALE";//задаем ожидаемую переменную для сравнения
        attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//нажимаем на товар в каталоге
        ProductPage.validateCatalogPage(expectedStatusSale, expectedNameOfTitleCatalog);
        System.out.println("Status is correct. Name of titles catalog is displayed correctly.");
    }

    @Description("Order is confirmed")
    @Story("Confirming my order on basket page")
    @Test
    public void myBasketConfirmOrder() {
        String expectedConfirmText = "Your order is successfully completed!";
        attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//выбираем нужный нам продукт
        ProductPage.selectButton("Small");//выбираем нужный нам селект
        ProductPage.clickAddToCardButton();//нажимаем на кнопку 'Add To Cart'
        $("span.quantity").shouldHave(text("1"));//задаем Явное ожидание

        ProductPage.clickBasketButton();//нажимаем на корзину
        BasketPage.clickConfirmButton();//нажимаем на кнопку Confirm
        BasketPage.validateOrderSuccessMessage(expectedConfirmText);
        System.out.println("Order is confirmed");
    }

    @Description("Orders was delete successfully from Basket.")
    @Story("Deleting product from basket")
    @Test
    public void myBasketDeleteOrder() {
        String expectedSuccessMessageDeleteText = "There are no items in your cart.";//задаем ожидаемую переменную для сравнения
        attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProductFromCatalogAfterSuccessLogin();//выбираем нужный нам продукт
        ProductPage.selectButton("Small");//выбираем нужный нам селект
        ProductPage.clickAddToCardButton();//нажимаем на кнопку 'Add To Cart'
        $("span.quantity").shouldHave(text("1"));//задаем Явное ожидание

        ProductPage.clickBasketButton();//нажимаем на корзину
        BasketPage.clickRemoveButton();//нажимаем на кнопку Remove
        BasketPage.validateSuccessMessageAfterDelete(expectedSuccessMessageDeleteText);
        System.out.println("Orders was delete successfully from Basket.");
    }
}
