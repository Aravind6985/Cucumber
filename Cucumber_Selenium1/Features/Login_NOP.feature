Feature: Login

@sanity
Scenario: Successful login with valid credentials
	Given Lunch Edge Browser
	When Open URL "https://admin-demo.nopcommerce.com/login"
	And Enter Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Click on logout link
	Then Page title should be "Your store. Login"
	And Close Browser

@regression
Scenario Outline: Login Details Data Driven
	Given Lunch Edge Browser
	When Open URL "https://admin-demo.nopcommerce.com/login"
	And Enter Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration" 
	When Click on logout link
	Then Page title should be "Your store. Login"
	And Close Browser
	
	Examples:
		| email | password |
		| admin@yourstore.com | admin|
		| admin1@yourstore.com | admin123 |



