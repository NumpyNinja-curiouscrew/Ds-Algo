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
		homePage.portalPage();  
        
    }

    @Then("the user should land on the DS Algo portal with a {string} button visible")
    public void the_user_should_land_on_the_ds_algo_portal_with_a_button_visible(String expectedButtonText) {
    	String actualButtonText=homePage.getGetStartedButtonText();// get text from page
        Assert.assertEquals(actualButtonText,expectedButtonText,"Button text does not match!");
       logger.info("Button text matches: " + actualButtonText);
  
    }
    
    @Given("the user is on the DS Algo Portal")
    public void the_user_is_on_the_ds_algo_portal() {
      homePage.portalPage();
      
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonText) {
      homePage.clickGetStartedButton(buttonText);
     
    }

    @Then("the user should be navigated to the Data Structures Introduction page")
    public void the_user_should_be_navigated_to_the_data_structures_introduction_page() {
      String expectedTitle = "NumpyNinja";
      Assert.assertEquals(homePage.getHomePage(),expectedTitle,"Page title does not match!");
      logger.info("Homepage opened");
      
    }
    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        homePage.getHomePage();
    }

    @When("the user clicks the Register link on the homepage without Sign-in")
    public void the_user_clicks_the_register_link_on_the_homepage() {
       homePage.clickRegisterLink();
    }

    @Then("the user should see the Register page")
    public void the_user_should_see_the_register_page() {
    	String expectedTitle = "Registration";
        Assert.assertEquals(homePage.getRegisterPage(),expectedTitle,"Page title does not match!");
        logger.info("RegisterPage opened");
        
    }

    @When("the user clicks the Sign-in link on the homepage without Sign-in")
    public void the_user_clicks_the_sign_in_link_on_the_homepage() {
       homePage.signInClick();
    }

    @Then("the user should see the Sign-in page")
    public void the_user_should_see_the_sign_in_page() {
    	String expectedTitle = "Login";
        Assert.assertEquals(homePage.getSignInPage(),expectedTitle,"Page title does not match!");
        logger.info("SignInPage opened");
        
    }
 	   
   
    @When("the user selects {string} from the dropdown without sign in")
    public void the_user_selects_from_the_data_structures_dropdown_without_signing_in(String option)  {
    	homePage.clickDropDown(option);
    }

    @Then("the user should see a warning message {string}")
    public void the_user_should_see_a_warning_message(String expectedMessage) {
    	    String actualMessage = homePage.warningMessage();  
    	    Assert.assertEquals(actualMessage,expectedMessage, "Warning message does not match!");
    	}
    
    @When("the user clicks the {string} Get Started button without sign in")
    public void the_user_clicks_the_get_started_button_without_signing_in(String section) {
    	homePage.clickingGetStarted(section);	
        
    }
    @Given("the user is signed in")
    public void the_user_is_signed_in()   {
        homePage.login();
        logger.info("user sign-in");
    }
    @When("the user selects {string} from the dropdown after sign-in")
    public void the_user_selects_from_the_data_structures_dropdown_after_sign_in(String option) {
         actualTitle=homePage.afterSignin_DropDown(option);  // Store returned title in a class variable
    }

    @Then("the user should be navigated to the introduction page for {string}")
    public void the_user_should_be_navigated_to_the_introduction_page_for(String expectedTitle) {
    	Assert.assertTrue(actualTitle.contains(expectedTitle), actualTitle + " doesn't match the expected title");
    }

    
    @When("the user clicks the {string} Get Started button with sign-in")
    public void the_user_clicks_the_get_started_button_with_sign_in(String option) {
    	actualTitle=homePage.afterSignin_GetStarted(option);
    	
    	
    }
   

    
    }


    

    
    


