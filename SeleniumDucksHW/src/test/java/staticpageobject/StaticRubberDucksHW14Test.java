package staticpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class StaticRubberDucksHW14Test extends TestBase1 {

    @Test
    public void myLoginDuckNegativeCase() {
        String ExpectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin(driver, "skachkov11@gmail.com", "qwerty12");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getColorErrorMessage(driver), LIGHT_PINK);
        softAssert.assertEquals(HomePage.getErrorMessageText(driver), ExpectedErrorMessageText);
        softAssert.assertAll();
        System.out.println("Page of profile isn't opened after tap on Login button.");
    }

    @Test
    public void myLoginDuckPositiveCase() {
        String ExpectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin(driver, "skachkovyury94@gmail.com", "Qwerty");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getColorCorrectMessage(driver), LIGHT_GREEN);
        softAssert.assertEquals(HomePage.getCorrectMessageText(driver), ExpectedCorrectMessageText);
        softAssert.assertAll();
        System.out.println("Page of profile is opened correctly!");
    }

    @Test
    public void myCatalogDuck() {
        String ExpectedNameOfTitleCatalog = "Similar Products";//задаем ожидаемую переменную для сравнения
        String ExpectedStatusSale = "SALE";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin(driver, "skachkovyury94@gmail.com", "Qwerty");
        HomePage.chooseProduct(driver);//нажимаем на товар в каталоге

        SoftAssert softAssert = new SoftAssert();//
        softAssert.assertEquals(ProductPage.getNameOfStatusDuckText(driver), ExpectedStatusSale);
        softAssert.assertEquals(ProductPage.getNameOfTitleCatalogText(driver), ExpectedNameOfTitleCatalog);
        softAssert.assertAll();
        System.out.println("Status is correct. Name of titles catalog is displayed correctly.");
    }

    @Test
    public void myBasketConfirmOrder() {
        String ExpectedConfirmText = "Your order is successfully completed!";
        LoginPage.attemptLogin(driver, "skachkovyury94@gmail.com", "Qwerty");//Логинимся
        HomePage.chooseProduct(driver);//выбираем нужный нам продукт
        ProductPage.selectButton(driver);//выбираем нужный нам селект
        ProductPage.buttonAddToCard(driver);//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        ProductPage.buttonBasket(driver);//нажимаем на корзину
        BasketPage.buttonConfirm(driver);//нажимаем на кнопку Confirm
        Assert.assertEquals(BasketPage.getConfirmText(driver), ExpectedConfirmText);
        System.out.println("Order is confirmed");
    }

    @Test
    public void myBasketDeleteOrder() {
        String ExpectedSuccessMessageDelete = "There are no items in your cart.";//задаем ожидаемую переменную для сравнения
        LoginPage.attemptLogin(driver, "skachkovyury94@gmail.com", "Qwerty");//Логинимся
        HomePage.chooseProduct(driver);//выбираем нужный нам продукт
        ProductPage.selectButton(driver);//выбираем нужный нам селект
        ProductPage.buttonAddToCard(driver);//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        ProductPage.buttonBasket(driver);//нажимаем на корзину
        BasketPage.buttonRemove(driver);//нажимаем на кнопку Remove
        Assert.assertEquals(BasketPage.getSuccessMessageDeleteText(driver), ExpectedSuccessMessageDelete);
        System.out.println("Orders was delete successfully from Basket.");
    }
}
