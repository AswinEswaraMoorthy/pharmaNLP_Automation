Feature: Regression Testing for PharmaNLP Workflow

  Scenario: PharmaNLP Workflow
    Given the user is logged in to the application
    When the user creates a project
    And the user searches for a PubMed keyword and imports the results
    And the user navigates to the Deduplication screen and adds items to screening
    And the user navigates to the Topic Analysis screen and runs ML prediction
    And the user navigates to the Full-Text screen and marks items as relevant
    And the user navigates to the Extraction screen
    And the user navigates to the Report screen
    Then the user completes the entire PharmaNLP workflow successfully
