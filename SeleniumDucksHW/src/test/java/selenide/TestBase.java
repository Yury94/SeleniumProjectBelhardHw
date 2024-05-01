package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
//import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

@Epic("Selenium training")
@Feature("Rubber ducks")
public class TestBase implements ITestListener {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @BeforeMethod
    protected void setup() {
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 25000;
        open("https://litecart.stqa.ru/en/");
//        Browser browser = Browser.valueOf(System.getProperty("browser", "edge"));
//        switch (browser) {
//            case chrome -> Configuration.browser = CHROME;
//            case edge -> Configuration.browser = EDGE;
//        }
    }

    @AfterMethod
    public void onTestFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File screenshort = Selenide.screenshot(OutputType.FILE);
            try {
                Allure.addAttachment(testResult.getMethod().getMethodName(), new FileInputStream(screenshort));
//                ReportPortal.emitLog(testResult.getMethod().getMethodName(), "ERROR", Calendar.getInstance().getTime(), screenshort);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    protected void teardown() {
        Selenide.closeWebDriver();
//        Selenide.clearBrowserCookies();
    }
}
