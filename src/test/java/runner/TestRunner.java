//package runner;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import poms.CustomerLoginHome;
//import poms.CustomerShoppingHome;
//
//
//import java.io.File;
//import java.time.Duration;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = {"src/main/resources/features"},
//        glue = "steps"
//)
//
//
//public class TestRunner {
//    public static WebDriver driver;
//    public static CustomerLoginHome customerLoginHome;
//    public static poms.poms.CustomerShoppingHome customerShoppingHome;
//
//
//
//    @BeforeClass
//    public static void setup(){
//        File file = new File("src/test/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        driver = new ChromeDriver();
//        customerLoginHome = new CustomerLoginHome(driver);
//        customerShoppingHome = new poms.poms.CustomerShoppingHome(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//    }
//
//    @AfterClass
//    public static void teardown(){
//        driver.quit();
//    }
//
//
//}
