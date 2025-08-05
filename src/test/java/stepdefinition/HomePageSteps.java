package stepdefinition;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverfactory.DriverFactory;
import pageobjects.HomePage;


public class HomePageSteps {
	
    private static final Logger logger = LoggerFactory.getLogger(HomePageSteps.class);
    private HomePage homePage =new HomePage(DriverFactory.getDriver());
    private String actualTitle;
	

	@Given("the user has opened the browser")
	public void the_user_has_opened_the_browser() {
		 logger.info("Opening browser...");
	    
	}
	@When("the user enters the correct DS Algo portal URL")
    public void the_user_enters_the_correct_ds_algo_portal_url() {
		logger.info("Navigating to DS Algo Portal URL");
		homePage.portalPage();  
        
    }

    @Then("the user should land on the DS Algo portal with a {string} button visible")
    public void the_user_should_land_on_the_ds_algo_portal_with_a_button_visible(String expectedButtonText) {
    	String actualButtonText=homePage.getGetStartedButtonText();
    	logger.info("Validating Get Started Button Text. Expected: {}, Actual: {}", expectedButtonText, actualButtonText);
        Assert.assertEquals(actualButtonText,expectedButtonText,"Button text does not match!");
        logger.info("Button text matches: " + actualButtonText);
  
    }
    
    @Given("the user is on the DS Algo Portal")
    public void the_user_is_on_the_ds_algo_portal() {
      logger.info("Navigating to DS Algo Portal Page");
      homePage.portalPage();
      
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonText) {
      logger.info("Clicking on '{}' button", buttonText);
      homePage.clickGetStartedButton(buttonText);
     
    }

    @Then("the user should be navigated to the Data Structures Introduction page")
    public void the_user_should_be_navigated_to_the_data_structures_introduction_page() {
      String expectedTitle = "NumpyNinja";
      logger.info("Validating Page Title");
      Assert.assertEquals(homePage.getHomePage(),expectedTitle,"Page title does not match!");
      logger.info("Homepage opened");
      
    }
    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
    	logger.info("Navigating to Home Page");
        homePage.getHomePage();
    }

    @When("the user clicks the Register link on the homepage without Sign-in")
    public void the_user_clicks_the_register_link_on_the_homepage() {
      logger.info("Clicking on Register link without Sign-in");
       homePage.clickRegisterLink();
    }

    @Then("the user should see the Register page")
    public void the_user_should_see_the_register_page() {
    	String expectedTitle = "Registration";
    	logger.info("Validating Register Page Title. Expected: {}, Actual: {}", expectedTitle, actualTitle);
        Assert.assertEquals(homePage.getRegisterPage(),expectedTitle,"Page title does not match!");
        logger.info("Navigated to Register Page successfully");
        
    }

    @When("the user clicks the Sign-in link on the homepage without Sign-in")
    public void the_user_clicks_the_sign_in_link_on_the_homepage() {
       logger.info("Clicking on Sign-in link without Sign-in");
       homePage.signInClick();
    }

    @Then("the user should see the Sign-in page")
    public void the_user_should_see_the_sign_in_page() {
    	String expectedTitle = "Login";
    	logger.info("Validating Sign-in Page Title. Expected: {}, Actual: {}", expectedTitle, actualTitle);
        Assert.assertEquals(homePage.getSignInPage(),expectedTitle,"Page title does not match!");
        logger.info("SignInPage opened");
        
    }
 	   
   
    @When("the user selects {string} from the dropdown without sign in")
    public void the_user_selects_from_the_data_structures_dropdown_without_signing_in(String option)  {
    	logger.info("Selecting '{}' from Data Structures dropdown without Sign-in", option);
    	homePage.clickDropDown(option);
    }

    @Then("the user should see a warning message {string}")
    public void the_user_should_see_a_warning_message(String expectedMessage) {
    	    String actualMessage = homePage.warningMessage();  
    	    logger.info("Validating Warning Message. Expected: '{}', Actual: '{}'", expectedMessage, actualMessage);
    	    Assert.assertEquals(actualMessage,expectedMessage, "Warning message does not match!");
    	}
    
    @When("the user clicks the {string} Get Started button without sign in")
    public void the_user_clicks_the_get_started_button_without_signing_in(String section) {
    	logger.info("Clicking '{}' Get Started button without Sign-in", section);
    	homePage.clickingGetStarted(section);	
        
    }
    @Given("the user is on the Home page after sign-in")
    public void the_user_is_signed_in()   {
    	homePage.getHomePage();
        homePage.login();
        logger.info("user sign-in");
    }
    @When("the user selects {string} from the dropdown after sign-in")
    public void the_user_selects_from_the_data_structures_dropdown_after_sign_in(String option) {
    	logger.info("Selecting '{}' from dropdown after Sign-in", option); 
    	actualTitle=homePage.afterSignin_DropDown(option);  // Store returned title in a class variable
    }

    @Then("the user should be navigated to the introduction page for {string}")
    public void the_user_should_be_navigated_to_the_introduction_page_for(String expectedTitle) {
    	logger.info("Validating page navigation after dropdown selection. Expected Title Part: '{}'", expectedTitle);
    	Assert.assertTrue(actualTitle.contains(expectedTitle), actualTitle + " doesn't match the expected title");
    	logger.info("Navigated successfully to introduction page for '{}'", expectedTitle);
    }

    
    @When("the user clicks the {string} Get Started button after sign-in")
    public void the_user_clicks_the_get_started_button_after_sign_in(String option) {
    	logger.info("Clicking '{}' Get Started button after Sign-in", option);
    	actualTitle=homePage.afterSignin_GetStarted(option);
    	
    	
    }
   

    
    }


    

    
    


