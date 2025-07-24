package pageobjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;


public class HomePage {
	
	 WebDriver driver;
	 private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	By getStartedButton = By.xpath("//*[contains(text(),'Get Started')]");
	By registerLink = By.xpath("//*[contains(text(), 'Register')]");
	By signInLink = By.xpath("//*[contains(text(), 'Sign in')]");
	By dataStructureDropdown = By.xpath("//*[text()='Data Structures']");
	By dataStructureDropdownOptions=By.xpath("//*[@class='dropdown-item']");
	By errorMsg=By.xpath("//*[contains(text(),'You are not logged in')]"); 
	By dataStructureGetStartedButton = By.xpath("//*[@href='data-structures-introduction']");
	By arrayGetStartedButton = By.xpath("//*[@href='array']");
	By linkedListGetStartedButton = By.xpath("//*[@href='linked-list']");
	By stackGetStartedButton = By.xpath("//*[@href='stack']");
	By queueGetStartedButton = By.xpath("//*[@href='queue']");
	By treeGetStartedButton = By.xpath("//*[@href='tree']");
	By graphGetStartedButton = By.xpath("//*[@href='graph']");
	By userNameTextBox = By.xpath("//*[@id='id_username']");
	By passwordTextBox = By.xpath("//*[@id='id_password']");
	By loginButton =By.xpath("//*[@value='Login']");
	By arraysDropDown=By.xpath("//*[contains(text(),'Arrays')]");
	By linkListDropDown=By.xpath("//*[@href='/linked-list']");
	By stackDropDown=By.xpath("//*[@href='/stack']");
	By queueDropDown=By.xpath("//*[@href='/queue']");
	By treeDropDown=By.xpath("//*[@href='/tree']");
	By graphDropDown=By.xpath("//*[@href='/graph']");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void portalPage() {
		String baseUrl = ConfigReader.get("baseUrl"); 
        driver.get(baseUrl);
	}
      
	public WebElement getGetStartedButton() {
        return driver.findElement(getStartedButton);
    }

    public String getGetStartedButtonText() {
    	return getGetStartedButton().getText();
    }
    public void clickGetStartedButton(String buttonText) {
    	if(getGetStartedButtonText()==buttonText){
    	driver.findElement(getStartedButton).click();}
    }

     public String getHomePage() {
		 portalPage();
		 getGetStartedButton().click();
         return driver.getTitle();
     }
     public WebElement registerLink() {
		return driver.findElement(registerLink);
    	 
     }
     public  void clickRegisterLink() {
    	 registerLink().click();
         
     }
     public String getRegisterPage() {
         return driver.getTitle();
     }
     public void signInClick() {
    	 driver.findElement(signInLink).click();
         
     }
     public String getSignInPage() {
         return driver.getTitle();
     
     }public WebElement dropDown(){
		return driver.findElement(dataStructureDropdown);
    	 
     }
     public void getDataStructureDropdown() {
    	 driver.findElement(dataStructureDropdown).click();
         }
  
 
     public void clickDropDown(String option)  {
    	   // example string you want to check
    	 getDataStructureDropdown();
        	 switch (option) {
     		 case "Array":
     			logger.info("User click on " +option);
     			driver.findElement(arraysDropDown).click();
     			
     			break;
     		case "Linked List":
     			logger.info("User click on " +option);
     			driver.findElement(linkListDropDown).click();
     			break;
     		case "Stack":
     			logger.info("User click on " +option);
     			driver.findElement(stackDropDown).click();
     			break;
     		case "Queue":
     			logger.info("User click on " +option);
     			driver.findElement(queueDropDown).click();
     			break;
     		case "Tree":
     			logger.info("User click on " +option);
     			driver.findElement(treeDropDown).click();
     			break;
     		case "Graph":
     			logger.info("User click on " +option);
     			driver.findElement(graphDropDown).click();
     			break;
     		}
    	 
    	 
     }
     public String warningMessage() {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
    	    return warning.getText();
    	}
     
     public void clickingGetStarted(String section) {
    	 switch (section) {
    	 
    	 case "Data Structures-Introduction":
    		 logger.info("User click on " + section);
  			driver.findElement(dataStructureGetStartedButton).click();
  			break;
 		 case "Array":
 			logger.info("User click on " +section);
 			driver.findElement(arrayGetStartedButton).click();
 			break;
 		case "Linked List":
 			logger.info("User click on " +section);
 			driver.findElement(linkedListGetStartedButton).click();
 			break;
 		case "Stack":
 			logger.info("User click on " +section);
 			driver.findElement(stackGetStartedButton).click();
 			break;
 		case "Queue":
 			logger.info("User click on " +section);
 			driver.findElement(queueGetStartedButton).click();
 			break;
 		case "Tree":
 			logger.info("User click on " +section);
 			driver.findElement(treeGetStartedButton).click();
 			break;
 		case "Graph":
 			logger.info("User click on " + section);
 			driver.findElement(graphGetStartedButton).click();
 			break;
 		}
 
     }
     public void login()   {
    	    signInClick();
    	    String username = ConfigReader.get("username");
    	    driver.findElement(userNameTextBox).sendKeys(username);
    	    String password = ConfigReader.get("password");
    	    driver.findElement(passwordTextBox).sendKeys(password);
    	    driver.findElement(loginButton).click();
    	    
    	}
     public String afterSignin_DropDown(String option) {
    	    clickDropDown(option);
    
    	        String pageTitle = driver.getTitle();
    	        logger.info("Navigated to page with title: " + pageTitle);
    	        return pageTitle;
    	    }
     public String afterSignin_GetStarted(String option) {
 	    
    	   clickingGetStarted(option);
 	        String pageTitle = driver.getTitle();
 	        logger.info("Navigated to page with title: " + pageTitle);
 	        return pageTitle;
 	    }
}