package nl.aggenebbisj.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import nl.aggenebbisj.util.PropertyLoader;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class BaseTest {

    protected WebDriver driver;
    protected String gridHubUrl;
    protected String baseUrl;

    @Before
    public void init() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

        Capabilities capabilities = PropertyLoader.loadCapabilities();
        
        if (capabilities.getBrowserName().equals("firefox")) {
            driver = new FirefoxDriver(capabilities);
        } else if (capabilities.getBrowserName().equals("phantomjs")) {
            driver = new PhantomJSDriver(capabilities);
        } else {
            throw new IllegalArgumentException("Unsupported browser!");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
