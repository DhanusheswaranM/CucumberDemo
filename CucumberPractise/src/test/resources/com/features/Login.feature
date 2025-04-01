Feature: Login Feature
  I want to use this feature to test the Login feature for OrangeHRM Web application  
  @ValidCredentials
  Scenario: To test Login feature using valid credentials
    Given I am in the OrangeHRM login page
    When user should provide valid Username
    And user should provide valid password
    And user clicks the login button
    Then user will see the DashboardText in the page