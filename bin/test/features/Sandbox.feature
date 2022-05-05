
  Feature: Test different actions on a sandbox page

    Scenario: As a Test Engineer, I try different actions on a sandbox page
      Given I navigate to the sandbox page
      And Select a value from the dropdown

    Scenario: As a Test Engineer, I want to upload a test document
      Given I navigate to the sandbox upload page
      And I upload a document

    @Test
    #40. Validar listas con loops
    Scenario: As a Test Engineer, I want to validate that a text is present inside the list.
      Given I navigate to the list page
      When I search the list
      Then I can find the text in the list

