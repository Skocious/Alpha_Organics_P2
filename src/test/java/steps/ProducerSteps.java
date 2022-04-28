package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class ProducerSteps {
    @Given("I am on Producers home page")
    public void i_am_on_producer_home_page() {
        TestRunner.driver.get("C:\\Users\\Will\\Desktop\\Alpha_Organics_P2\\src\\main\\HTML_JS\\producerHomepage.html");
    }
    @When("I enter the {string} in to the item id field")
    public void i_enter_the_item_id_into_the_item_id_input_bar(String string) {
        TestRunner.producer.itemId.sendKeys(string);
    }
    @When("I enter the {string} in to the item description field")
            public void i_enter_the_item_description_into_the_item_description_field(String string) {
        TestRunner.producer.itemDescription.sendKeys(string);
    }

    @When("I enter a {string} in to the price field")
    public void i_enter_price_into_the_item_price_field(String string) {
        TestRunner.producer.price.sendKeys(string);
    }

    @When("I click the item submit button")
    public void I_click_the_item_submit_button() { TestRunner.producer.CreateItem.click();}

    @Then("I can post an item to sell")
    public void i_can_post_an_item_to_sell() {  Assert.assertEquals(TestRunner.driver.getTitle(),"Alpha Organic's Producer Homepage");}

    @When("I enter a valid {string} in to the cancel item field")
    public void I_enter_a_valid_itemId_in_the_field(String string) { TestRunner.producer.deleteField.sendKeys(string);}

    @When("I click the delete button")
    public void I_click_the_delete_button() { TestRunner.producer.deleteButton.click();}

    @Then("I can delete the item")
    public void I_can_delete_the_item() {Assert.assertEquals(TestRunner.driver.getTitle(),"Alpha Organic's Producer Homepage");}

    @When("I click on producer Log out button")
    public void i_click_the_producer_logout_button() {
        TestRunner.producer.ProducerLogout.click();
    }

    @Then("I producer logout successfully and got back to the Login page")
    public void i_producer_logout_successfully() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Alpha Organics", title);
    }
}
