package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    @FindBy(css = "[class='main-image fancybox zoomable shadow']")
    private WebElement nameOfStatusDuck;
    @FindBy(xpath = "//*[@id='box-similar-products']/h3")
    private WebElement nameOfTitleCatalog;
    @FindBy(css = "button[value='Add To Cart']")
    private WebElement buttonAddToCard;
    @FindBy(xpath = "//*[@id='cart']/a[@class='link']")
    private WebElement buttonBasket;
    @FindBy(css = "[name='options[Size]']")
    private WebElement buttonSelect;


    public  String getNameOfStatusDuckText () {
        return nameOfStatusDuck.getText();
    }
    public  String getNameOfTitleCatalogText () {
        return nameOfTitleCatalog.getText();
    }

    public void buttonAddToCard () {
        buttonAddToCard.click();
    }
    public void buttonBasket () {
        buttonBasket.click();
    }
    public void selectButton () {
        Select select = new Select(buttonSelect);
        select.selectByValue("Small");//выбираем нужный нам селект
    }
}
