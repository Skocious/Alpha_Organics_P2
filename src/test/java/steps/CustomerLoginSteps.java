package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class CustomerLoginSteps {
    @Given("I am on the Login home page")
    public void i_am_on_the_login_home_page() {
        TestRunner.driver.get("");
    }
    @When("I enter {string} into the customer login input bar")
    public void i_enter_into_the_customer_login_input_bar(String string) {
        TestRunner.customerLoginHome.LoginName.sendKeys(string);
    }
    @When("I type out {string} into the customer password input bar")
    public void i_type_out_into_the_customer_password_input_bar(String string) {
        TestRunner.customerLoginHome.Password.sendKeys(string);
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        TestRunner.customerLoginHome.CustomerLogin.click();
    }
    @Then("I should be on customer home page")
    public void i_should_be_on_customer_home_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Alpha Organic's Customer Page",title);
    }


}