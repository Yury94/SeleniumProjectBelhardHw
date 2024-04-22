package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ObjectRubberDucksHW14Test extends TestBase {

    @Test
    public void myLoginDuckNegativeCase() {
        String ExpectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения

        LoginPage loginPage = new LoginPage(driver);//инициализируем обьект класса LoginPage
        HomePage homePage = new HomePage(driver);//инициализируем обьект класса HomePage
        loginPage.attemptLogin("skachkov11@gmail.com", "qwerty12");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getColorErrorMessage(), LIGHT_PINK);
        softAssert.assertEquals(homePage.getErrorMessageText(), ExpectedErrorMessageText);
        softAssert.assertAll();
        System.out.println("Page of profile isn't opened after tap on Login button.");
    }

    @Test
    public void myLoginDuckPositiveCase() {
        String ExpectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        LoginPage loginPage = new LoginPage(driver);//инициализируем обьект класса LoginPage
        HomePage homePage = new HomePage(driver);//инициализируем обьект класса HomePage
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getColorCorrectMessage(), LIGHT_GREEN);
        softAssert.assertEquals(homePage.getCorrectMessageText(), ExpectedCorrectMessageText);
        softAssert.assertAll();
        System.out.println("Page of profile is opened correctly!");
    }

    @Test
    public void myCatalogDuck() {
        String ExpectedNameOfTitleCatalog = "Similar Products";//задаем ожидаемую переменную для сравнения
        String ExpectedStatusSale = "SALE";//задаем ожидаемую переменную для сравнения
        LoginPage loginPage = new LoginPage(driver);//инициализируем обьект класса LoginPage
        Catalog catalog = new Catalog(driver);//инициализируем обьект класса Catalog
        ProductPage productPage = new ProductPage(driver);
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");
        catalog.chooseProduct();//нажимаем на товар в каталоге

        SoftAssert softAssert = new SoftAssert();//
        softAssert.assertEquals(productPage.getNameOfStatusDuckText(), ExpectedStatusSale);
        softAssert.assertEquals(productPage.getNameOfTitleCatalogText(), ExpectedNameOfTitleCatalog);
        softAssert.assertAll();
        System.out.println("Status is correct. Name of titles catalog is displayed correctly.");
    }

    @Test
    public void myBasketConfirmOrder() {
        String ExpectedConfirmText = "Your order is successfully completed!";
        LoginPage loginPage = new LoginPage(driver);//инициализируем обьект класса LoginPage
        Catalog catalog = new Catalog(driver);//инициализируем обьект класса Catalog
        ProductPage productPage = new ProductPage(driver);//инициализируем обьект класса ProductPage
        Basket basket = new Basket(driver);//инициализируем обьект класса Basket
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");//Логинимся
        catalog.chooseProduct();//выбираем нужный нам продукт
        productPage.selectButton();//выбираем нужный нам селект
        productPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        productPage.buttonBasket();//нажимаем на корзину
        basket.buttonConfirm();//нажимаем на кнопку Confirm
        Assert.assertEquals(basket.getConfirmText(), ExpectedConfirmText);
        System.out.println("Order is confirmed");
    }

    @Test
    public void myBasketDeleteOrder() {
        String ExpectedSuccessMessageDelete = "There are no items in your cart.";//задаем ожидаемую переменную для сравнения
        LoginPage loginPage = new LoginPage(driver);//инициализируем обьект класса LoginPage
        Catalog catalog = new Catalog(driver);//инициализируем обьект класса Catalog
        ProductPage productPage = new ProductPage(driver);//инициализируем обьект класса ProductPage
        Basket basket = new Basket(driver);//инициализируем обьект класса Basket
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");//Логинимся
        catalog.chooseProduct();//выбираем нужный нам продукт
        productPage.selectButton();//выбираем нужный нам селект
        productPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        productPage.buttonBasket();//нажимаем на корзину
        basket.buttonRemove();//нажимаем на кнопку Remove
        Assert.assertEquals(basket.getSuccessMessageDeleteText(), ExpectedSuccessMessageDelete);
        System.out.println("Orders was delete successfully from Basket.");
    }
}
