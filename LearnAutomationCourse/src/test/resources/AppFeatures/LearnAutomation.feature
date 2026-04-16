Feature:



Scenario: Login to the application
Given User should be on login page
When User gets title of the page
Then Page title should be "Learn Automation Courses"

Scenario: Login with username and password
Given User should be on login page
When User enters email "admin@email.com" 
And User enters pwd "admin@123"
And User clicks on sign in button
Then User navigates to Home page


