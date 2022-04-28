package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Producer {

    private WebDriver driver;
    public Producer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="item_field")
    public WebElement itemId;
    @FindBy(id="item_description_field")
    public WebElement itemDescription;
    @FindBy(id = "item_price_field")
    public WebElement price;
    @FindBy(id= "buy button")
    public WebElement CreateItem;
    @FindBy(id= "delete-Item-Request-Field")
    public WebElement deleteField;
    @FindBy(id= "cancelButton")
    public WebElement deleteButton;
    @FindBy(id = "producerLo22goutButton")
    public WebElement ProducerLogout;
}