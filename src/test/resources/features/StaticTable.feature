@Test
Feature: Test different actions on the Static Table Page

  Rule: The user can return values from the table and validate them.

  Background: Navigate to Table web app
  Given I navigate to the static table

  Scenario: As a Test Engineer, I want to retrieve the value of a static table
  Then I can return the value I wanted

  #Creo un Scenario para verificar si la tabla está ahí
  Scenario: As a Test Engineer, I want to validate the static table is displayed.
  Then I can validate the table is displayed