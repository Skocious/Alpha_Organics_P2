//package poms;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class ProducerLoginHome {
//    private WebDriver driver;
//    public ProducerLoginHome(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }
//    @FindBy(id = "username-field")
//    public WebElement loginName;
//    @FindBy(id="password-field")
//    public WebElement password;
//    @FindBy(id = "producerLoginButton")
//    public WebElement ProducerLogin;
//
//}