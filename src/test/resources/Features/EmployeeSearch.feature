Feature: Searching the Employee
Background:
  When user enters valid login and valid password
  And click on login button
  When user click on PIM option
  @regression
  Scenario: Search Employee by id
    #Given open the browser and launch HRM application
    #When user enters valid login and valid password
    #And click on login button
    #When user click on PIM option
    When user enters valid Employee ID in the textbox
    And click on Search button
    And user see employee information displayed
    #And Close the browser
@regression
    Scenario: Search Employee by Employment status
     # Given open the browser and launch HRM application
      #When user enters valid login and valid password
      #And click on login button
      #When user click on PIM option
      When user select Employment status dropdown
      And click on Search button
      And user see employee information displayed
      #And Close the browser


