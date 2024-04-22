import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DucksLoginCatalogBasketHW13Test {

    @Test
    public void myLoginDuckNegativeCase() {
        String ExpectedErrorMessageText = "Wrong password or the account is disabled, or does not exist";//задаем ожидаемую переменную для сравнения
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("skachkov11@gmail.com");//ввод некорректного email
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty12");//ввод некорректного пароля

        WebElement login = driver.findElement(By.name("login"));//поиск кнопки Login
        login.click();

        WebElement errorMessageElement = driver.findElement(By.xpath("//*[@class='notice errors']"));//поиск элемента для assert
        String errorMessageText = errorMessageElement.getText();//для assert получаем текст из элемента в переменную String
        Assert.assertEquals(errorMessageText, ExpectedErrorMessageText);
        System.out.println("Page of profile isn't opened after tap on Login button. ");
        driver.quit();
    }

    @Test
    public void myLoginDuckPositiveCase() {
        String ExpectedCorrectMessageText = "You are now logged in as Yury Skachkov.";//задаем ожидаемую переменную для сравнения
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("skachkovyury94@gmail.com");//ввод корректного email
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Qwerty");//ввод корректного пароля

        WebElement login = driver.findElement(By.name("login"));//поиск кнопки Login
        login.click();

        WebElement correctMessageElement = driver.findElement(By.xpath("//*[@class='notice success']"));//поиск элемента для assert
        String correctMessageText = correctMessageElement.getText();//для assert получаем текст из элемента в переменную String
        Assert.assertEquals(correctMessageText, ExpectedCorrectMessageText);
        System.out.println("Page of profile is opened correctly after tap on Login button. ");
        driver.quit();
    }

    @Test
    public void myCatalogDuck() {
        String ExpectednameOfTitleCatalog = "Similar Products";//задаем ожидаемую переменную для сравнения
        String ExpectedStatusSale = "SALE";//странно, что в коде указано sale

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement duck1 = driver.findElement(By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']"));//находим товар Sale
        duck1.click();

        WebElement nameOfStatusDuck = driver.findElement(By.cssSelector("[class='main-image fancybox zoomable shadow']"));//поиск для 1 assert
        String nameOfStatusDuckText = nameOfStatusDuck.getText();//для 1 assert получаем текст из элемента в переменную String

        WebElement nameOfTitleCatalog = driver.findElement(By.xpath("//*[@id='box-similar-products']/h3"));//поиск для 2 assert
        String nameOfTitleCatalogText = nameOfTitleCatalog.getText();//для 2 assert получаем текст из элемента в переменную String

        SoftAssert softAssert = new SoftAssert();//
        softAssert.assertEquals(nameOfStatusDuckText, ExpectedStatusSale);
        softAssert.assertEquals(nameOfTitleCatalogText, ExpectednameOfTitleCatalog);
        softAssert.assertAll();
        System.out.println("Name of titles catalog is displayed correctly.");
        driver.quit();
    }

    @Test
    public void myBasketConfirmOrder() {
        String ExpectedConfirmText = "Your order is successfully completed!";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("skachkovyury94@gmail.com");//ввод корректного email
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Qwerty");//ввод корректного пароля
        WebElement login = driver.findElement(By.name("login"));//поиск кнопки Login
        login.click();//Логинимся

        WebElement duck1 = driver.findElement(By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']"));//находим товар Sale
        duck1.click();
        Select select = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        select.selectByValue("Small");//выбираем нужный нам селект
        WebElement duck2 = driver.findElement(By.cssSelector("button[value='Add To Cart']"));
        duck2.click();//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement duck3 = driver.findElement(By.xpath("//*[@id='cart']/a[@class='link']"));
        duck3.click();//нажимаем на корзину
        WebElement duck4 = driver.findElement(By.xpath("//*[@name='confirm_order']"));
        duck4.click();//нажимаем на кнопку 'Remove'

        WebElement ConfirmText = driver.findElement(By.xpath("//*[@id='box-order-success']/h1"));//поиск элемента для assert
        String correctConfirmText = ConfirmText.getText();//для assert получаем текст из элемента в переменную String
        Assert.assertEquals(correctConfirmText, ExpectedConfirmText);
        System.out.println("Order is confirmed");
        driver.quit();
    }

    @Test
    public void myBasketDeleteOrder() {
        String ExpectedSuccessMessageDelete = "There are no items in your cart.";//задаем ожидаемую переменную для сравнения

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement duck1 = driver.findElement(By.cssSelector("[id='box-most-popular']>div>ul>li>a>div div[class='sticker sale']"));//находим товар Sale
        duck1.click();
        Select select = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        select.selectByValue("Small");//выбираем нужный нам селект
        WebElement duck2 = driver.findElement(By.cssSelector("button[value='Add To Cart']"));
        duck2.click();//нажимаем на кнопку 'Add To Cart'

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));//задаем Явное ожидание
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        WebElement duck3 = driver.findElement(By.xpath("//*[@id='cart']/a[@class='link']"));
        duck3.click();//нажимаем на корзину
        WebElement duck4 = driver.findElement(By.cssSelector("[name='remove_cart_item']"));
        duck4.click();//нажимаем на кнопку 'Remove'

        WebElement SuccessMessageDelete = driver.findElement(By.xpath("//em"));//поиск элемента для assert
        String SuccessMessageDeleteText = SuccessMessageDelete.getText();//для assert получаем текст из элемента в переменную String
        Assert.assertEquals(SuccessMessageDeleteText, ExpectedSuccessMessageDelete);
        System.out.println("Orders was delete successfully from Basket.");
        driver.quit();
    }
}
