package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import poms.CustomerLoginHome;
import poms.CustomerShoppingHome;
import poms.Producer;
import poms.ProducerLoginHome;
import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = "steps",
        plugin = {"pretty","html:src/main/resources/html-e2e-report.html"}
)


public class TestRunner {
    public static WebDriver driver;
    public static CustomerLoginHome customerLoginHome;
    public static CustomerShoppingHome customerShoppingHome;
    public static ProducerLoginHome producerLoginHome;
    public static Producer producer;

    @BeforeClass
    public static void setup(){
        File file = new File("src/test/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        customerLoginHome = new CustomerLoginHome(driver);
        customerShoppingHome = new CustomerShoppingHome(driver);
        producerLoginHome = new ProducerLoginHome(driver);
        producer = new Producer(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }


}
