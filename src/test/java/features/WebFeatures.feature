@functionalTest

Feature: automate all diff type of webelement


Background: loin to practice url
Given login to practice url

@Smoketest1
Scenario: radio button example

Given landed on homepage
When  u will see radio button
Then click on radio button

@Smoketest2
Scenario: auto suggesstion box example

Given click on auto suggesstion text box
When  enter just ind
Then select india from auto suggesstion

@Smoketest3
Scenario: dropdown box example

Given click on dropdown
When  select any value from dropdown
Then click on that value

@Smoketest4
Scenario: check box example

Given click on checkbox
When  apply isdiplayed,isenabled,isselected

@Smoketest5
Scenario: switch child window example

Given click on child window link
When  chld window will get opened
Then  move to child window and verify

@Smoketest6
Scenario: switch tab example

Given click on open tab link
And verify title of new page 
And click on courses

@Smoketest7
Scenario: switch to alert

Given enter text and click on alert
And then extract data from alert  
And click on ok
And click on confirm button and then cancel button

@Smoketest8
Scenario: mouse hover

Given click on mousehover
And select reload option 

@Smoketest9
Scenario: table

Given access all elements of webtable
And rows column header  

@Smoketest10
Scenario: hide element

Given enter text in field
And then click on hide and show button

@Smoketest11
Scenario: iframe

Given identify i frame
And then click on mentorship