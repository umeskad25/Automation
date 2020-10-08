Feature: EDU AUT Login
  Scenario: To test success status
    Given Rates API for Latest Foreign Exchange rates
    When The API is available
    Then validate the status
    
    Scenario: To test rsponse status
    Given Rates API for Latest Foreign Exchange rates
    When The Response is available
    Then validate the response body
    
    Scenario: To test rsponse status
    Given Rates API for Latest Foreign Exchange API
    When The Response of API is ready
    Then validate the incorrect API response
    
    
    