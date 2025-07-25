package stepdefinition;

import static org.testng.Assert.assertEquals;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.LinkedListPage;

public class LinkedListPageSteps {
	 private HomePage homePage = new HomePage(DriverFactory.getDriver());
	 private LinkedListPage linkedListPage = new LinkedListPage(DriverFactory.getDriver());
	 String actualPage;
	 String actualTitle;
		
		@Given("The user is logged in to the dsAlgo portal")
		public void the_user_is_logged_in_to_the_ds_algo_portal() {
			 homePage.getHomePage();
			 homePage.login();
		}

		@Given("The user is on the {string} page")
		public void the_user_is_on_the_page(String string) {
		   homePage.afterSignin_GetStarted(string);
		}

		@When("The user clicks on the string link")
		public void the_user_clicks_on_the_link() {
			actualPage = linkedListPage.getToIntroPage();
		   
		}

		@Then("The user should be redirected to the {string} page")
		public void the_user_should_be_redirected_to_the_page(String expectedPage) {
		   assertEquals("Page title does not match",expectedPage, actualPage);
		}

		@When("The user clicks string link")
		public void the_user_clicks_link() {
			actualTitle = linkedListPage.getToPracticePage();
			}

		@Then("The user should be redirected to {string} page")
		public void the_user_should_be_redirected_to_page(String string) {
			   assertEquals("Page title does not match", string, actualTitle);
		}

		@When("The user clicks string button")
		public void the_user_clicks_button() {
		   
		}

		@Then("The user should be redirected to a {string} page having an try Editor with a Run button to test")
		public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Given("The user is in the {string} page accessed from Introduction page")
		public void the_user_is_in_the_page_accessed_from_introduction_page(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("The user clicks the {string} button without entering the code in the Editor")
		public void the_user_clicks_the_button_without_entering_the_code_in_the_editor(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("The user should see the same try Editor with a Run button")
		public void the_user_should_see_the_same_try_editor_with_a_run_button() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("The user writes invalid code in the Editor and clicks the {string} button")
		public void the_user_writes_invalid_code_in_the_editor_and_clicks_the_button(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("The user should see an error message in an alert window")
		public void the_user_should_see_an_error_message_in_an_alert_window() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("The user writes valid code in the Editor and clicks the {string} b`utton")
		public void the_user_writes_valid_code_in_the_editor_and_clicks_the_b_utton(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("The user should see the output in the console")
		public void the_user_should_see_the_output_in_the_console() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}



	}



