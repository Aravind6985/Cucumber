Feature: OrangeHRM Login
Scenario: Logo present on Orang HRM home page
Given I launch edge browser
When I open orange HRM home page
Then I verify that the logo is present
And Close browser