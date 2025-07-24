package pageobjects;




import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegisterPage {
    
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(RegisterPage.class);
   
	
    // locators
    By usernameInput = By.id("id_username");            
    By passwordInput = By.id("id_password1");
    By confirmPasswordInput = By.id("id_password2");
    By registerButton = By.xpath("//*[@value='Register']");
    
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Field id map for validation
    private static final Map<String, String> fieldIdMap = new HashMap<>();
    static {
        fieldIdMap.put("username", "id_username");
        fieldIdMap.put("password", "id_password1");
        fieldIdMap.put("confirmPassword", "id_password2");
    }

   

    public void enterUsername(String username) {
    	WebElement input = driver.findElement(usernameInput);
        input.clear();
        input.sendKeys(username == null ? "" : username);
    }

    public void enterPassword(String password) {
    	WebElement input = driver.findElement(passwordInput);
        input.clear();
        input.sendKeys(password == null ? "" : password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement  input = driver.findElement(confirmPasswordInput);
        input.clear();
        input.sendKeys(confirmPassword == null ? "" : confirmPassword);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getFieldId(String fieldName) {
        return fieldIdMap.get(fieldName);
    }
    
   
    
    
}
