@smoke
Feature: Google Searching


  Scenario Outline: Search for <searchItems> on Google

    Given I am on the Google Search Page
    When I type "<searchItems>" into the search box
    And I press the search button
    Then I should see the search results

    Examples:
      | searchItems |
      | Billy       |
      | Ciaran      |
      | Grainne     |