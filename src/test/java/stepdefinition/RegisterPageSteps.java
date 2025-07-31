package stepdefinition;
import static org.testng.Assert.assertEquals;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utils.ExcelUtils;


public class RegisterPageSteps {

	private RegisterPage registerPage;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private static final Logger logger = LoggerFactory.getLogger(RegisterPageSteps.class);
    private Map<String, String> testData;
    String expectedError;
    String actualError;
	private Scenario scenario;
	
 @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
        registerPage = new RegisterPage(DriverFactory.getDriver());
    }

@Given("the user is on the user registration page")
public void the_user_is_on_the_user_registration_page() {
	homePage.getHomePage();
	homePage.clickRegisterLink();
}

@When("the user enters valid testdata and click run button.")
public void the_user_enters_valid_testdata_and_click_run_button() {
testData = ExcelUtils.readExcelRow(scenario.getName(), "Register");
    String username = testData.get("username");
    registerPage.enterPassword(username);
    String password = testData.get("password");
	registerPage.enterPassword(password);
	String confirmPassword = testData.get("confirmPassword");
	registerPage.enterConfirmPassword(confirmPassword);
	expectedError = testData.get("expectedError");
	String fieldname= testData.get("fieldName");
	System.out.println(username);
	System.out.println(password);
	System.out.println(confirmPassword);
	System.out.println(fieldname);
	registerPage.clickRegister();
	actualError = registerPage.actualError(fieldname);
	
}

@Then("the user should be able to see the error message Please fill out this field displayed below the empty field.")
public void the_user_should_be_able_to_see_the_error_message_please_fill_out_this_field_displayed_below_the_empty_field() {
	assertEquals(actualError,expectedError,"Error is not diaplayed");
}



}