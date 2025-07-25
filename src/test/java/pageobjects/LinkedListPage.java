package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverfactory.DriverFactory;

public class LinkedListPage {
	 WebDriver driver;
	 private static final Logger logger = LoggerFactory.getLogger(LinkedListPage.class);
	 
	 By introPageLink = By.xpath("//*[@href='introduction']");
	 By practicePageLink =By.xpath("//*[contains(text(),'Practice Questions')]");
	 
	 
	 
	 public LinkedListPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 public String getToIntroPage() {
		 driver.findElement(introPageLink).click();
		 return driver.getTitle();
	
	 }
	 public String getToPracticePage() {
		 driver.findElement(practicePageLink).click();
		 return driver.getTitle();
	
	 }
}
