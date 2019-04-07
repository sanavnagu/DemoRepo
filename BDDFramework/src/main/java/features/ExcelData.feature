Feature: Excel Data Reader

  Background: Given a workbook named "LoginPage.xlsx" and sheet named "Data" is read

  Scenario Outline: User Login scenario
    Given I am in Login page of the application
    When I Enter the "<username>" and "<password>" 
    Then I should Navigate to home page

    Examples: 
      | username | password |
      | UserName | Password |
