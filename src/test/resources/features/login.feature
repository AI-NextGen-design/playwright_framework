Feature: Login

  Scenario: Verify login feature execution
    Given Navigate to the OrangeHRM login page
    When Enter login credentials and click on login button
    Then User should see the upgrade button and get "Upgrade" text