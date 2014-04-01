package nl.aggenebbisj.test;

import java.io.IOException;
import nl.aggenebbisj.pages.HomePage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

public class PageHeaderTest extends BaseTest {
    
private HomePage homepage;

  @Before
  @Override
  public void init() throws IOException {
      super.init();
      driver.get(baseUrl);
      homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    assertFalse("".equals(homepage.header.getText()));
  }    
}
