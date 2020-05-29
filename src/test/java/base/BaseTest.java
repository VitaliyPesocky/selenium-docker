package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER -> chrome / firefox
        // HUB_HOST -> localhost / 10.0.1.3 / hostname

        String host = "localhost";
        DesiredCapabilities desiredCapabilities;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            desiredCapabilities = DesiredCapabilities.firefox();
        } else {
            desiredCapabilities = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completedUrl = "http://" + host + ":4444/wd/hub";

        String testName = ctx.getCurrentXmlTest().getName();
        desiredCapabilities.setCapability("name", testName);

        this.driver = new RemoteWebDriver(new URL(completedUrl), desiredCapabilities);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
