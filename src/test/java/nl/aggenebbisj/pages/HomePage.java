package nl.aggenebbisj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

  @FindBy(how = How.NAME, using = "trefwoord")
  @CacheLookup
  public WebElement searchbar;
  
  @FindBy(how = How.NAME, using = "ZoekOp")
  private WebElement searchButton;
  
  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
  
  public DetailPage search(String query) {
      searchbar.click();
      searchbar.sendKeys(query);
      searchButton.click();
      
      return new DetailPage(driver);
  }
}
