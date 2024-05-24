package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basket {
    @FindBy(xpath = "//*[@id='box-order-success']/h1")
    private WebElement confirmText;
    @FindBy(xpath = "//em")
    private WebElement successMessageDelete;
    @FindBy(xpath = "//*[@name='confirm_order']")
    private WebElement buttonConfirm;
    @FindBy(css = "[name='remove_cart_item']")
    private WebElement buttonRemove;

    public  String getConfirmText () {
        return confirmText.getText();
    }
    public  String getSuccessMessageDeleteText () {
        return successMessageDelete.getText();
    }

    public void buttonConfirm () {
        buttonConfirm.click();
    }
    public void buttonRemove () {
        buttonRemove.click();
    }

}
