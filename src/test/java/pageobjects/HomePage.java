package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;


public class HomePage {
	
	 WebDriver driver;

	By getStartedButton = By.xpath("//*[contains(text(),'Get Started')]");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void openHomePage() {
		String baseUrl = ConfigReader.get("baseUrl"); 
        driver.get(baseUrl);
    }
   
	public String getGetStartedButtonText() {
		WebElement button = driver.findElement(getStartedButton);
		return button.getText();
	}

}

