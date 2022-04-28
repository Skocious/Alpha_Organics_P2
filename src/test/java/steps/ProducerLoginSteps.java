//package steps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//import runner.TestRunner;
//
//public class ProducerLoginSteps {
//    @Given("I am on the Login home page")
//    public void i_am_on_the_login_home_page() {
//        TestRunner.driver.get("C:\\Users\\Will\\Desktop\\Alpha_Organics_P2\\src\\main\\HTML_JS\\landingPage.html");
//    }
//    @When("I enter {string} into the producer login input bar")
//    public void i_enter_into_the_producer_login_input_bar(String string) {
//        TestRunner.producerLoginHome.loginName.sendKeys(string);
//    }
//    @When("I type out {string} into the producer password input bar")
//    public void i_type_out_into_the_producer_password_input_bar(String string) {
//        TestRunner.producerLoginHome.password.sendKeys(string);
//    }
//    @When("I click the login button")
//    public void i_click_the_login_button() {
//        TestRunner.producerLoginHome.ProducerLogin.click();
//    }
//    @Then("I should be on producer home page")
//    public void i_should_be_on_producer_home_page() {
//        String title = TestRunner.driver.getTitle();
//        Assert.assertEquals("Alpha Organic's Producer Homepage", title);
//    }
//
//}