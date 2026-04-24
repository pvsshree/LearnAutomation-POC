Feature: Manage Courses



Given User has already logged in to application
And User is on home page


Background:
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

 
Scenario: Add Course Details
Given User is on Add New Course popup
When User clicks on choose file and selects a file 
Then That file should be selected
When User enters course Name "BDD FRAMEWORK" in Course name field
And User enters description "Cucumber with Selenium - End to End framework with POM" in description field
And User enters instructor "Payal S" in instructor field
And User enters price 500 in price field
And User selects date in starts from field
And User selects date in ends on field
And User does not check the Permanent checkbox
And User selects the category in category field
    |SQl |
    |JS|
    |AWS|
    |Selenium|
    |Javascript|
    |PHP|
    |MySQL|
And Click on Save Button
Then course "BDD FRAMEWORK" has been successfully added

