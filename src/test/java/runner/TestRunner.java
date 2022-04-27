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
import poms.ProducerLoginHome;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/ProducerLogin.feature"},
        glue = "src/test/java/steps"
)
//@CucumberOptions(
//        features = {"src/main/resources/features/CustomerLogin.feature"},
//        glue = "src/test/java/steps",
//        plugin = {"pretty","src/main/resources/html-e2e-report.html"}
//)

public class TestRunner {
    public static WebDriver driver;
    public static CustomerLoginHome customerLoginHome;
    public static CustomerShoppingHome customerShoppingHome;
    public static ProducerLoginHome producerLoginHome;


    @BeforeClass
    public static void setup(){
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        customerLoginHome = new CustomerLoginHome(driver);
        customerShoppingHome = new CustomerShoppingHome(driver);
        producerLoginHome = new ProducerLoginHome(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }


}
