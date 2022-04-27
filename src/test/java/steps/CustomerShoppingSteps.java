package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class CustomerShoppingSteps {

    @Given("I am on customer home page")
    public void i_am_on_customer_home_page() {
        TestRunner.driver.get("");
    }
    @When("I enter the {ItemId} into the ItemId input bar")
    public void i_enter_the_item_id_into_the_item_id_input_bar(String string) {
        TestRunner.customerShoppingHome.ItemID.sendKeys(string);
    }
    @When("I see the item in the item added to the cart")
    public void i_see_the_item_in_the_item_added_to_the_cart() {
        TestRunner.customerShoppingHome.AddToCart.click();
    }
    @When("I click the buy now button")
    public void i_click_the_buy_now_button() {
        TestRunner.customerShoppingHome.Buy.click();
    }
    @When("I see an alert item bought successfully")
    public void i_see_an_alert_item_bought_successfully() {
        TestRunner.driver.switchTo().alert();
    }
    @When("I click the logout button")
    public void i_click_the_logout_button() {
        TestRunner.customerShoppingHome.Logout.click();
    }
    @Then("I logout successfully and got back to the Login page")
    public void i_logout_successfully_and_got_back_to_the_login_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Alpha Organics", title);
    }


}