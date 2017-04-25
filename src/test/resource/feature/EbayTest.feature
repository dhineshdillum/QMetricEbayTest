Feature: ebay Test

  Scenario: eBay
    Given user opens the ebay homepage
    When user search for an "iphone"
    And user sorts product by "Lowest price + P&P"
    And user filters by "Auction"
    Then the first item has "Free Postage"
    And the first item has a "bid" to it
    And the first item has a price

