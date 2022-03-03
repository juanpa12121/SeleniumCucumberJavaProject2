
  Feature: Test different actions on a sandbox page

    Scenario: As a Test Engineer, I try different actions on a sandbox page
      Given I navigate to the sandbox page
      And Select a value from the dropdown


    Scenario: As a Test Engineer, I want to retrieve the value of a static table
      Given I navigate to the static table
      Then I can return the value I wanted

    @Test
    Scenario: As a Test Engineer, I want to upload a test document
      Given I navigate to the sandbox upload page
      And I upload a document


