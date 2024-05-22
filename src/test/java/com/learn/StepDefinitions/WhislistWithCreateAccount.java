package com.learn.StepDefinitions;

import com.learn.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static com.learn.base.Base.driver;

public class WhislistWithCreateAccount {
    public HomePage homePage;
    public CreateAccountPage createAccountPage;
    public WhishListPage whishListPage;
    public WomenPage womenPage;

    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        homePage = new HomePage(driver);
        whishListPage = new WhishListPage(driver);
    }
    @When("I click on Account button")
    public void i_click_on_account_button() {
        homePage.clickAccount();
        homePage.clickOnCreateAccount();

    }
    @When("I am on Create an Account page")
    public void i_am_on_create_an_account_page() {
        createAccountPage = new CreateAccountPage(driver);

    }
    @When("I Enter Firstname and Lastname Email, DOB and Password")
    public void iEnterFirstnameAndLastnameEmailDOBAndPassword() {
      createAccountPage.setFnLn();
      createAccountPage.setEmail();
      createAccountPage.dateOfBirth();
      createAccountPage.enterPassword();

    }
    @When("I click on Terms CheckBox and Click on Create an Account button")
    public void i_click_on_terms_check_box_and_click_on_create_an_account_button() {
        createAccountPage.clickCreateAccount();
    }
    @When("I goto women page and select subCategory")
    public void i_goto_women_page_and_select_sub_category() {
        womenPage = new WomenPage(driver);
        womenPage.selectCategorypage();
    }

    @And("I add three products to WishList")
    public void iAddThreeProductsToWishList() {
      womenPage.addWishListItems();

    }
    @When("I goto WishList")
    public void iGotoWishList() {
        womenPage.clickWishListIcon();

    }
    @Then("I Verify the WishList items present in WishList")
    public void iVerifyTheWishListItemsPresentInWishList() {
        whishListPage.verifywishListItems();
        Assert.assertEquals(womenPage.actualWishlistitems,whishListPage.ExceptedWishlistitems);


    }
    @When("I click on Sign out")
    public void i_click_on_sign_out() {
        whishListPage.signOut();


    }



}
