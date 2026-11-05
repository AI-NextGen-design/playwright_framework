Feature: Landing Page

  Scenario: Verify the side menu options
    Given Navigate to the OrangeHRM login page
    When Enter login credentials and click on login button
    Then navigate the side menu options
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |