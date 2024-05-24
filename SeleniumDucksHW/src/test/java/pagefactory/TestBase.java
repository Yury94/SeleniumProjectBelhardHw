package pagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject.Browser;

import java.time.Duration;

public class TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    WebDriver driver;

    @BeforeMethod
    protected void setup() {
//        driver = WebDriverManager.chromedriver().create();

        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));

        driver = switch (browser) {
            case edge -> new EdgeDriver();
            case chrome -> new ChromeDriver();
            case ie -> new InternetExplorerDriver();
            case safari -> new SafariDriver();
            case firefox -> new FirefoxDriver();
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    void teardown(){
        driver.quit();
    }
}
