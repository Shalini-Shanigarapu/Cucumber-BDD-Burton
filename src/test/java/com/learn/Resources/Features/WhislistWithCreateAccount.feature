# new feature
# Tags: optional

Feature:As a user,
    I want to Create an Account with Valid credentials and add whishlist.
@whishlist
  Scenario: Create Account and Add Whitelist
    Given I am on HomePage
    When I click on Account button
    And I am on Create an Account page
    When I Enter Firstname and Lastname Email, DOB and Password
    And I click on Terms CheckBox and Click on Create an Account button
    When I goto women page and select subCategory
    And I add three products to WishList
    When I goto WishList
    Then I Verify the WishList items present in WishList
    When I click on Sign out





