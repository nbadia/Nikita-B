Feature: Verify the header page positive scenarios

  Scenario: Validate that the mpowered health logo/hamburger in the header
    Given Launch URL
    When Navigated to the 'Header' page
    Then Verify hamburger in the header

  Scenario: Validation of the Drop down tab
    Given Click on Drop down or  hamburger tab
    Then Verify the drop down options

  Scenario: Validate profile page on clicking  Your profile tab
  Given Click on Drop down or  hamburger tab
  When click on  Your profile
  Then Verify the profile page

  Scenario: Validate  Your ratings dashboard
  Given Click on Drop down or  hamburger tab
  When click on  Your ratings
  Then Verify the ratings dashboard page.

  Scenario: Validate the alerts page
    When Click on Your alerts icon
    Then Verify the alerts page

  Scenario: Validate Help or FAQ  page
    Given Click on Drop down or  hamburger tab
    When click on Help icon
    Then Verify  the help or FAQ page

  Scenario: Validate  Privacy Policy dialogue box on clicking on the Privacy Policy
    Given Click on Drop down or  hamburger tab
    When click on  Privacy Policy
    Then Verify the dialogue box

  Scenario: Validate Terms & Conditions dialogue box on clicking on the Terms & Conditions
    Given Click on Drop down or  hamburger tab
    When click on  Terms & Conditions
    Then Verify the  dialogue box on terms and conditions page

  Scenario: Validate the Contact Us page
    Given Click on Drop down or  hamburger tab
    When click on  Contact Us
    Then Verify  Contact Us page

  Scenario: Validate that the user is navigated to the Feedback Port   page  on clicking Feedback
    Given Click on Drop down or  hamburger tab
    When click on  Feedback
    And Verify the Feedback Port.
    Then Verify the thank you message

  Scenario: Validate the Landing page on clicking Log out icon
    When click on Log out icon
    Then Verify navigation to the Landing  page