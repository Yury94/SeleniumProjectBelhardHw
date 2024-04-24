package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @BeforeMethod
    protected void setup() {
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920х1080";
        Configuration.pageLoadTimeout = 25000;
        open("https://litecart.stqa.ru/en/");
//        Browser browser = Browser.valueOf(System.getProperty("browser", "edge"));
//        switch (browser) {
//            case chrome -> Configuration.browser = CHROME;
//            case edge -> Configuration.browser = EDGE;
//        }
    }

    @AfterMethod
    protected void teardown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
