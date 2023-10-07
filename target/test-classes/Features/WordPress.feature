
Feature:  WordPress Website Testing

  @SmokeTest1
  Scenario: Verify the WordPress websiteo
   Given I am on the WordPress website "https://wordpress.org/"
   Then I verify the title of the page is as expected
   When I hover over Download & Extend and click Get WordPress
   Then I verify the text "Get WordPress" is displayed
   And I click on Community and click on Photo Directory
   And I search for a picture and verify the pictures are displayed
  

  
