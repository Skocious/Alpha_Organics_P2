package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class CustomerShoppingSteps {

    @Given("I am on customer home page")
    public void i_am_on_customer_home_page() {
        TestRunner.driver.get("C:\\Users\\Will\\Desktop\\Alpha_Organics_P2\\src\\main\\HTML_JS\\customerHomepage.html");
    }
    @When("I enter the {string} into the ItemId input bar")
    public void i_enter_the_item_id_into_the_item_id_input_bar(String string) {
        TestRunner.customerShoppingHome.ItemID.sendKeys(string);
    }
    @When("I click the buy now button")
    public void i_click_the_buy_now_button() {
        TestRunner.customerShoppingHome.Buy.click();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        TestRunner.customerShoppingHome.Logout.click();
    }

    @Then("I customer logout successfully and got back to the Login page")
    public void i_logout_successfully_and_got_back_to_the_login_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Alpha Organics", title);
    }


}