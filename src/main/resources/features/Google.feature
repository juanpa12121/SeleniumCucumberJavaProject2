Feature: Probar la búsqueda en Google

  Scenario: Busco algo en Google
    Given Navego a google
    When Busco algo
    Then Obtengo resultados
