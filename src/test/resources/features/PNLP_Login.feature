#aswin.moorthy@capestart.com
@Regression
@Login
Feature: PharmaNLP Login Functionallity

  Scenario: Authorized users can login PharmaNLP application
    Given User lauch the PharmaNLP application
    Then The logo should occur
    When User login with Invalid username and password
    When User login with valid username and password
    Then User successfully navigate to My Projects page
