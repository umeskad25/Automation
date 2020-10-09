Feature: Rates API for Specific date Foreign Exchange rates
  Scenario: To test Exchange rated for specific date
    Given Rates API for specific date
    When The API is Ready
    Then validate the status Response
    
    Scenario: To test Exchange rated response for specific date
    Given Rates API for specific date
    When The API is Ready
    Then validate the status body Response
    
    Scenario: To test Exchange rated response for future date
    Given Rates API for future date
    When response ready for future date
    Then validate the status response for future date
