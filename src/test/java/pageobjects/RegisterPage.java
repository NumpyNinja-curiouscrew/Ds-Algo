package pageobjects;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverfactory.DriverFactory;


public class RegisterPage {
    
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(RegisterPage.class);
    String actualResult;
    By usernameInput = By.id("id_username");            
    By passwordInput = By.id("id_password1");
    By confirmPasswordInput = By.id("id_password2");
    By registerButton = By.xpath("//*[@value='Register']");
    By errorText = By.xpath("//*[contains(@class,'alert')]");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

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

   public String actualError(String fieldname) {
	   String fieldId=fieldIdMap.get(fieldname);
	   WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(fieldId)));
	    JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getDriver();
	    actualResult = (String) js.executeScript(
	        "return document.getElementById(arguments[0]).validationMessage;",fieldId
	    );
	return actualResult;
	   
   }
   
   public String errorText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
	    return driver.findElement(errorText).getText();
	}
    
}
