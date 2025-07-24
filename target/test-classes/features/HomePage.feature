
# Sample Feature Definition Template for DS Algo Portal Testing
# Scenario Outline: Uses <placeholders> with Examples table for data-driven testing
# Background: Common steps run before each scenario
# """ (Doc Strings)
# | (Data Tables)
# @ (Tags): Useful for grouping and filtering scenarios
# <> (Placeholder for dynamic values)
# "" and ## are for comments

@register
Feature: DS Algo Portal - Home Page and Navigation

  Scenario: Verify the user can open the DS Algo portal
    Given the user has opened the browser
    When the user enters the correct DS Algo portal URL
    Then the user should land on the DS Algo portal with a "Get Started" button visible
    
  Scenario: Verify the Home page for a user without signing in
    Given the user is on the DS Algo Portal
    When the user clicks the "Get Started" button
    Then the user should be navigated to the Data Structures Introduction page
   
 Scenario: Verify the user is able to navigate to the Register page without signing in
    Given the user is on the Home page
    When the user clicks the Register link on the homepage without Sign-in
    Then the user should see the Register page

  Scenario: Verify the user is able to navigate to the Sign-in page without signing in
    Given the user is on the Home page
    When the user clicks the Sign-in link on the homepage without Sign-in
    Then the user should see the Sign-in page
    

  Scenario Outline: Verify that user able to see warning message when selecting "<option>" from dropdown without signing in
  Given the user is on the Home page
  When the user selects "<option>" from the dropdown without sign in
  Then the user should see a warning message "You are not logged in"

    Examples:
  | option       |
  | Array        |
  | Linked List  |
  | Stack        |
  | Queue        |
  | Tree         |
  | Graph        |
  
  
  Scenario Outline: Verify that user able to see warning message on clicking  "<section>" Get Started button without signing in
    Given the user is on the Home page
    When the user clicks the "<section>" Get Started button without sign in
    Then the user should see a warning message "You are not logged in"

   Examples:
      | section                |
      | Data Structures-Introduction|
      | Array                  |
      | Linked List            |
      | Stack                  |
      | Queue                  |
      | Tree                   |
      | Graph                  |
  
       
 Scenario Outline: Verify navigation to "<option>" introduction page from dropdown options after sign-in
  Given the user is on the Home page 
  And the user is signed in
  When the user selects "<option>" from the dropdown after sign-in
  Then the user should be navigated to the introduction page for "<option>"

 Examples:
  | option       |
  | Array        |
  | Linked List  |
  | Stack        |
  | Queue        |
  | Tree         |
  | Graph        |
  

 Scenario Outline: Verify navigation to introduction page on clicking "<section>" Get Started button after sign-in
    Given the user is on the Home page
    And the user is signed in
    When the user clicks the "<section>" Get Started button with sign-in
    Then the user should be navigated to the introduction page for "<section>"

   Examples:
      | section                |
      | Data Structures-Introduction|
      | Array                  |
      | Linked List            |
      | Stack                  |
      | Queue                  |
      | Tree                   |
      | Graph                  | 
   
   