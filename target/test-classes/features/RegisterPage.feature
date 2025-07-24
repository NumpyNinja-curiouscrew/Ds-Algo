# Sample Feature Definition Template for DS Algo Portal Testing
# Scenario Outline: Uses <placeholders> with Examples table for data-driven testing
# Background: Common steps run before each scenario
# """ (Doc Strings)
# | (Data Tables)
# @ (Tags): Useful for grouping and filtering scenarios
# <> (Placeholder for dynamic values)
# "" and ## are for comments



 
 Feature: User Registration Validation

  Background:
    Given the user is on the user registration page
    
   Scenario: Error message is displayed when the Username field is left empty
    When the user clicks the Register button after entering field from excel.
    Then the error message should be displayed under the empty field.

  Scenario: Error message is displayed when the Password field is left empty
    When the user clicks the Register button after entering field from excel.
    Then the error message should be displayed under the empty field.

  Scenario: Error message is displayed when the Password Confirmation field is left empty
    When the user clicks the Register button after entering field from excel.
    Then the error message should be displayed under the empty field.
    
  Scenario: Error messages are displayed when all fields are empty during registration.
  When the user clicks the Register button after entering field from excel.
  Then the error message should be displayed under the empty field.