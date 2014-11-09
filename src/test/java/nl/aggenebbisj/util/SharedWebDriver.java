package nl.aggenebbisj.util;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class SharedWebDriver extends EventFiringWebDriver {

    public static String baseUrl = PropertyLoader.loadProperty("application.url");;

    public SharedWebDriver() {
        super(getDriver());
    }

    private static WebDriver getDriver() {
        // TODO Choose browser based on properties here
        WebDriver driver = new ChromeDriver(DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void navigateToBaseUrl() {
        get(baseUrl);
    }

    @After
    public void tearDown() {
        close();
    }
}
