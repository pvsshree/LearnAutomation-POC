Feature:

Background:
Given User has already logged in to application
|email      |password     |
|admin@email.com|admin@123|

Scenario: Navigate to manage course section
Given User is on "Home page"
When User hovers to Manage see the dropdown options
And User clicks on Manage Courses
Then User navigates to Manage Courses page
Then Page title should be "Manage Courses"
 
 
Scenario: Add New Course
Given User is on "Manage Courses"
When User clicks on Add New Course
Then Popup for Add New Course should be displayed
And Page title should be "Add New Course"