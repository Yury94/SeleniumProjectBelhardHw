package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.*;

import java.time.Duration;

public class FactoryRubberDucksHW14Test extends TestBase {

    @Test
    public void myLoginDuckNegativeCase() {
        String ExpectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);//инициализируем обьект класса LoginPage

        loginPage.attemptLogin("skachkov11@gmail.com", "qwerty12");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);//инициализируем обьект класса HomePage

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getColorErrorMessage(), LIGHT_PINK);
        softAssert.assertEquals(homePage.getErrorMessageText(), ExpectedErrorMessageText);
        softAssert.assertAll();
        System.out.println("Page of profile isn't opened after tap on Login button.");
    }

    @Test
    public void myLoginDuckPositiveCase() {
        String ExpectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);//инициализируем обьект класса LoginPage

        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);//инициализируем обьект класса HomePage

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
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);//инициализируем обьект класса LoginPage
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");

        Catalog catalog = PageFactory.initElements(driver, Catalog.class);//инициализируем обьект класса Catalog
        catalog.chooseProduct();//нажимаем на товар в каталоге

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        SoftAssert softAssert = new SoftAssert();//
        softAssert.assertEquals(productPage.getNameOfStatusDuckText(), ExpectedStatusSale);
        softAssert.assertEquals(productPage.getNameOfTitleCatalogText(), ExpectedNameOfTitleCatalog);
        softAssert.assertAll();
        System.out.println("Status is correct. Name of titles catalog is displayed correctly.");
    }

    @Test
    public void myBasketConfirmOrder() {
        String ExpectedConfirmText = "Your order is successfully completed!";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);//инициализируем обьект класса LoginPage
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");//Логинимся

        Catalog catalog = PageFactory.initElements(driver, Catalog.class);//инициализируем обьект класса Catalog
        catalog.chooseProduct();//выбираем нужный нам продукт

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);//инициализируем обьект класса ProductPage
        productPage.selectButton();//выбираем нужный нам селект
        productPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'

        Basket basket = PageFactory.initElements(driver, Basket.class);//инициализируем обьект класса Basket

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
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);//инициализируем обьект класса LoginPage
        loginPage.attemptLogin("skachkovyury94@gmail.com", "Qwerty");//Логинимся

        Catalog catalog = PageFactory.initElements(driver, Catalog.class);//инициализируем обьект класса Catalog
        catalog.chooseProduct();//выбираем нужный нам продукт

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);//инициализируем обьект класса ProductPage
        productPage.selectButton();//выбираем нужный нам селект
        productPage.buttonAddToCard();//нажимаем на кнопку 'Add To Cart'

        Basket basket = PageFactory.initElements(driver, Basket.class);//инициализируем обьект класса Basket

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        productPage.buttonBasket();//нажимаем на корзину
        basket.buttonRemove();//нажимаем на кнопку Remove
        Assert.assertEquals(basket.getSuccessMessageDeleteText(), ExpectedSuccessMessageDelete);
        System.out.println("Orders was delete successfully from Basket.");
    }
}
