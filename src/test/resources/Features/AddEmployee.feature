Feature: Add Employee

  Background:#defines all the common steps that multiple scenarios have in same feature file
    When user enters valid login and valid password
    And click on login button
    When user click on PIM option

  @regression1
  Scenario: Adding a new Employee
    #Given open the browser and launch HRM application
    #When user enters valid login and valid password
    #And click on login button
    #When user click on PIM option
    And user clicks on add employee butten
    And user enters first name and middlename and lastname
    And user clicks on save button
    #And Close the browser
