# new feature
# Tags: optional

Feature: As a User
    I want to Sign In with Valid credentials and add Products to Cart.

    Scenario Outline: Sign In and Add Products to Cart
        Given I am on the HomePage
        When I click on Account Button
        And I click on Sign In and I am on Sign In page
        When I Enter "<EmailId>" and "<Password>"
        And I click on Sign In Button
        When I goto Women page and select subCategory
        And I add three products to Cart
        When I goto Cart
        Then I Verify the add Products present in Cart
        When I click on Sign Out

        Examples:
        |EmailId             |Password|
        |Hacklock@yopmail.com|Hack@123|
