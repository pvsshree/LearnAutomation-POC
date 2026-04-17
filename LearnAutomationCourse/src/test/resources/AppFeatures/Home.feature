Feature: Manage Courses

Background:
Given User has already logged in to application
|email      |password     |
|admin@email.com|admin@123|
When User hovers to Manage see the dropdown options
And User clicks on Manage Courses
Then User navigates to Manage Courses page

  
Scenario: Popup for Add New Course
When User clicks on Add New Course
Then Popup for Add New Course should be displayed


Scenario: save button
Given User is on Add New Course popup
When Click on Save Button without entering values
Then Message "Please fill all the fields" should be diplayed


Scenario: choose file
Given User is on Add New Course popup
When User clicks on choose file and selects a file 
Then That file should be selected