
package nl.aggenebbisj.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import nl.aggenebbisj.util.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

class BaseTest {
  protected WebDriver driver;
  protected String gridHubUrl;
  protected String baseUrl;

  @Before
  public void init() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Capabilities capabilities = PropertyLoader.loadCapabilities();

    driver = new PhantomJSDriver(capabilities);

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @After
  public void tearDown() {
    if (driver != null) {
        driver.close();
    }
  }
}
