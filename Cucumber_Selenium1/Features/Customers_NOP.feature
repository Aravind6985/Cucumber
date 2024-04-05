Feature: Customer

	Background: Below are common steps for each secnario
		Given Lunch Edge Browser
		When Open URL "https://admin-demo.nopcommerce.com/login"
		And Enter Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login
		Then User can view Dashboard

@sanity
	Scenario: Add a new customer
		When User click on customers menu 
		And Click on customer menu item
		And Click on Add new button
		Then User can view Add new customer page
		When User enter customer info
		And Click on save button
		Then User can view confirmation message "The new customer has been added successfully."
		And Close Browser
		
@regression
	Scenario: Search customer by email id	
		When User click on customers menu
		And Click on customer menu item
		And Enter customer email
		When Click on search button
		Then User should find customer email in the table
		And Close Browser

@regression		
	Scenario: Search customer by First name & last name
		When User click on customers menu
		And Click on customer menu item
		And Enter customer First Name
		And Enter customer Last Name
		When Click on search button
		Then User should find name in the table
		And Close Browser	

