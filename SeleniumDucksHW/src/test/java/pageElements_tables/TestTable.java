package pageElements_tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestTable {

    @Test
    public void tableTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/tables");

        TablePage tablePage  = new TablePage(driver);

        Assert.assertEquals(tablePage.table1.getRowsCount(), 5);
        System.out.println(tablePage.table2.getCell(3, 3).getText());
        System.out.println("Количестко строк = " + tablePage.table1.getRowsCount() + ".");
        System.out.println("Количестко столбцов = " + tablePage.table1.getColumnsCount() + ".");
        System.out.printf("Количестко столбцов = %d.", tablePage.table1.getColumnsCount());
        driver.quit();
    }
}
