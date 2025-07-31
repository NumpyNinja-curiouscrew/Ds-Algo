package pageobjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.DriverFactory;

public class LinkedListPage {
	 WebDriver driver;
	 private HomePage homePage = new HomePage(DriverFactory.getDriver());
	 By introPageLink = By.xpath("//*[@href='introduction']");
	 By practicePageLink =By.xpath("//*[contains(text(),'Practice Questions')]");
	 By linkedListButton =By.xpath("//*[@href='linked-list']");
	 By tryHereButton =By.xpath("//*[@href='/tryEditor']");
	 By tryEditor = By.xpath("//*[@class='CodeMirror-scroll']");
	 By runButton =By.xpath("//*[contains(text(),'Run')]");
	 By output =By.xpath("//*[@id='output']");
	 By createLinkedListLink=By.xpath("//*[@href='creating-linked-list']");
	 By typesofLinkedListLink=By.xpath("//*[@href='types-of-linked-list']");
	 By implementLinkedListLink=By.xpath("//*[@href='implement-linked-list-in-python']");
	 By traversalLink=By.xpath("//*[@href='traversal']");
	 By insertionLink=By.xpath("//*[@href='insertion-in-linked-list']");
	 By deletionLink=By.xpath("//*[@href='deletion-in-linked-list']");
	 
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
	 
		 
		 public void getToLinkedList() {
			    homePage.getHomePage();
			    homePage.login();

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(linkedListButton));

			    driver.findElement(linkedListButton).click();     
			}     
		 
	
	 public String clicktryHere() {
		 
		 WebElement trybutton=driver.findElement(tryHereButton);
		 trybutton.click(); 
		 return driver.getTitle();
		 
	 }
	 
	 public boolean runButtonVisible() {
		 
	 WebElement runTab = driver.findElement(runButton);
	 if (runTab.isDisplayed()) {
	     return true;
	 } else {
	     return false;
	 }
	 }
	 public boolean editorVisible() {
		 
		 WebElement editor = driver.findElement(tryEditor);
		 if (editor.isDisplayed()) {
		     return true;
		 } else {
		     return false;
		 }
	 
	 }

	 public String enterData(String inputData) {
		 if (inputData != null && !inputData.isEmpty()) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", 
		        inputData
		    );
		 }
		    WebElement runBtn = driver.findElement(runButton);
		    runBtn.click();
          
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    if (isAlertPresent()) {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert text: " + alertText);
		        alert.accept();
		        return alertText;
		    } else {
		        WebElement consoleOutput = driver.findElement(output);
		        String text = consoleOutput.getText();
		        System.out.println("text"+text);
		        return text;
		        }
		    }

	private boolean isAlertPresent() {
		try {
	        driver.switchTo().alert();
	        return true;
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
	}
	
	public String getToCreatingLinkedListPage() {
		 driver.findElement(createLinkedListLink).click();
		 return driver.getTitle();
	
	 }
	public String getToimplementLinkedListPage() {
		 driver.findElement(implementLinkedListLink).click();
		 return driver.getTitle();
	
	 }
	public String getTotypesofLinkedListPage() {
		 driver.findElement(typesofLinkedListLink).click();
		 return driver.getTitle();
	
	 }
	public String getTotraversalPage() {
		 driver.findElement(traversalLink).click();
		 return driver.getTitle();
	
	 }
	public String getToPage() {
		 driver.findElement(createLinkedListLink).click();
		 return driver.getTitle();
	
	 }
	public String getToinsertionPage() {
		 driver.findElement(insertionLink).click();
		 return driver.getTitle();
	
	 }
	public String getTodeletionPage() {
		 driver.findElement(deletionLink).click();
		 return driver.getTitle();
	
	 }
}


	 


