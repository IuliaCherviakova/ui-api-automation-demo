Feature:API workflow for HRMS

  Background:
    Given  a JWT is generated

  @api
  Scenario: create an employee using API call
    Given a request is prepared to create an employee
    When a POST call is made to create a new employee
    Then the status code for creating an employee is 201
    Then the emplyee contains key "Message" and value "Employee Created"
    Then the "employee id" is stored as a global variable to be used for other calls

  @apijsonworkflow
  Scenario: create an employee using API call
    Given a request is prepared to create an employee using json payload
    When a POST call is made to create a new employee
    Then the status code for creating an employee is 201
    Then the emplyee contains key "Message" and value "Employee Created"
    Then the "employee id" is stored as a global variable to be used for other calls