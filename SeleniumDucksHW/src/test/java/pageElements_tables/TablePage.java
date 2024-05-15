package pageElements_tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage {

    private By table1Locator = By.id("table1");
    private By table2Locator = By.id("table2");


        Table table1;
        Table table2;
        WebDriver driver;

        public TablePage (WebDriver driver) {
            this.driver = driver;
            table1 = new Table(driver.findElement(table1Locator));
            table2 = new Table(driver.findElement(table2Locator));
    }


}
