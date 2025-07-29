Feature: Login Functionalities
  @smoke
  Scenario: Valid Admin Login
    #Given open the browser and launch HRM application
    When user enters valid login and valid password
    And click on login button
    Then user is logged in successfully
    #And Close the browser

  @smoke
  Scenario: Valid Admin Login
    #Given open the browser and launch HRM application
    When user enters valid "Admin" and valid "admin123"
    And click on login button
    Then user is logged in successfully
    #And Close the browser

@scenarioOutline @smoke
  #Parameterization/ Data driven
  Scenario Outline: Login with multiple credetials using Scenerio outline
    #Given open the browser and launch HRM application
    When user enters valid "<login>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    #And Close the browser
  Examples:
    |login|password|
    |Admin|admin123|
    |admin|ADMIN123|
    |jason|admin123|

  @dataTable @smoke
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      |login|password|
      |Admin|admin123|
      |Admin|admin123|
      |Admin|admin123|