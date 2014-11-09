package nl.aggenebbisj.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.How.TAG_NAME;

/**
 * Sample page
 */
public class HomePage extends Page {

    @FindBy(how = TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
}
