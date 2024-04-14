import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    @Test
    public void myFirstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement id = driver.findElement(By.id("content"));//Выбираем id, где содержится список ссылок
        List<WebElement> elements = id.findElements(By.tagName("a"));//находим каждую ссылку в id
        for (WebElement element : elements) {
            System.out.println(element.getText() + "-" + element.getAttribute("href"));//вывод в консоль каждого элемента (ссылки) из elements
        }
        elements.get(9).click();
        driver.quit();
    }

    @Test
    public void myFirstTestForDuck() {
        String ExpectedNameOfHomePage = "Most Popular";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement duck1 = driver.findElement(By.xpath("//li[@class='general-0']"));
        duck1.click();

        WebElement rubber = driver.findElement(By.xpath("//img[@title='ACME Corp.']"));//для 1 assert
        boolean elementIsVisible = rubber.isDisplayed();//для 1 assert преобразуем в переменную boolean
        WebElement nameOfHomePage = driver.findElement(By.cssSelector("div[id='box-most-popular'] h3"));//для 2 assert
        String nameOfHomePageText = nameOfHomePage.getText();//для 2 assert получаем текст из элемента в переменную String

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(elementIsVisible, "Element is not visible");
        softAssert.assertEquals(nameOfHomePageText, ExpectedNameOfHomePage);
        softAssert.assertAll();
        System.out.println("Name of page HOME is displayed correctly. Page is open after tap on HOME button.");
        driver.quit();
    }

    @Test
    public void mySecondTestForDuck() {
        String ExpectedNameOfSecondPage = "Rubber Ducks";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement duck2 = driver.findElement(By.xpath("//li[@class='category-1']"));
        duck2.click();

        WebElement rubber = driver.findElement(By.xpath("//li[@class='category shadow hover-light']"));//для 1 assert
        boolean elementIsVisible = rubber.isDisplayed();//для 1 assert преобразуем в переменную boolean
        WebElement nameOfSecondPage = driver.findElement(By.cssSelector("h1[class='title']"));//для 2 assert
        String nameOfSecondPageText = nameOfSecondPage.getText();//для 2 assert получаем текст из элемента в переменную String

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(elementIsVisible, "Element is not visible");
        softAssert.assertEquals(nameOfSecondPageText, ExpectedNameOfSecondPage);
        softAssert.assertAll();
        System.out.println("Name of page Rubber Ducks is displayed correctly. Page is open after tap on Rubber Ducks button.");
        driver.quit();
    }

    @Test
    public void myThirdTestForDuck() {
        String ExpectedNameOfPageSubcategory = "Subcategory";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement duck = driver.findElement(By.xpath("//li[@class='category-1']"));

        Actions bilder = new Actions(driver);
        bilder.pause(3000).moveToElement(duck).perform();
        WebElement duck3 = duck.findElement(By.xpath("//li[@class='category-1']/ul/li[@class='category-2']"));
        duck3.click();

//        WebElement nameOfPageSubcategory = driver.findElement(By.xpath("//*[@id='box-category']/h1"));
        WebElement nameOfPageSubcategory = driver.findElement(By.cssSelector("div[id='box-category']>h1"));
        String nameOfSubcategoryPageText = nameOfPageSubcategory.getText();//получаем текст из элемента nameOfPageSubcategory
        Assert.assertEquals(nameOfSubcategoryPageText, ExpectedNameOfPageSubcategory);
        System.out.println("Name of page Subcategory is displayed correctly. Page is open after tap on Subcategory button.");
        driver.quit();
    }
}


