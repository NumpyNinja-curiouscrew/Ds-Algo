package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverfactory.DriverFactory;
import pageobjects.HomePage;
public class HomePageSteps {
	
    private HomePage homepage =new HomePage(DriverFactory.getDriver());

	
	@Given("the user has opened the browser")
	public void the_user_has_opened_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertNotNull(DriverFactory.getDriver(), "WebDriver is not initialized");
	    System.out.println("Browser session started successfully.");
	}
	@When("the user enters the correct DS Algo portal URL")
    public void the_user_enters_the_correct_ds_algo_portal_url() {
        homepage.openHomePage();
    }

    @Then("the user should land on the DS Algo portal with a {string} button visible")
    public void the_user_should_land_on_the_ds_algo_portal_with_a_button_visible(String buttonText) {
    	String actualButtonText = homepage.getGetStartedButtonText();// get text from page
    	String expectedButtonText ="Get Started";
        Assert.assertEquals(actualButtonText, expectedButtonText, 
            "Button text does not match!");
        System.out.println("Button text matches: " + actualButtonText);
  
    }
}



