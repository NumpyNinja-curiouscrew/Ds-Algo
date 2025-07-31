

Feature: User Registration Validation


  Background:
    Given the user is on the user registration page
    
  Scenario: validate the error message displayed when the username field is left empty	
    When the user clicks the Register button after entering a valid password and confirm password.	
    Then  the user should be able to see the error message Please fill out this field. displayed below the username input field.

 Scenario: validate the error message displayed when the password field is left empty	
    When  the user clicks the Register button after entering a valid username and confirm password.	 
    Then  the user should be able to see the error message Please fill out this field. displayed below the password input field.
    
  Scenario: validate the error message displayed when the confirm password field is left empty
     When the user clicks the Register button after entering a valid password and username .
     Then  The user should be able to see the error message Please fill out this field. displayed below the confirm password input field.
  
  Scenario: validate the error message displayed when all the fields  left empty	
    When 	The user clicks the Register button with all fields empty	
    Then  the user should be able to see the error message Please fill out this field. displayed below the username input field.
    
    Scenario: validate the registration page with multiple test data 
    When user enters "	 valid for validation of username password and clicks on redister button
    Then user should able to see this expectedoutput