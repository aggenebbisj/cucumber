package nl.aggenebbisj.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.aggenebbisj.pages.HomePage;
import nl.aggenebbisj.util.SharedWebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomePageHeaderTest {

    private HomePage homepage;

    public HomePageHeaderTest(SharedWebDriver driver) {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.navigateToBaseUrl();
    }

    @Given("^a User has no money in their account$")
    public void a_User_has_no_money_in_their_account() {
        assertThat(homepage.header.getText(), is("Hello Cucumber!"));
    }

    @When("^£(\\d+) is deposited in to the account$")
    public void £_is_deposited_in_to_the_account(int arg1) {
    }

    @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(int arg1) {
    }
}
