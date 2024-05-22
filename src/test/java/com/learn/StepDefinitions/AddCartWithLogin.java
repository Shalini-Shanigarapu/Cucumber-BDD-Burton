package com.learn.StepDefinitions;

import com.learn.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static com.learn.base.Base.driver;

public class AddCartWithLogin {
    public HomePage homePage;
    public WomenPage womenPage;
    public SignInPage signInPage;
    public CartPage cartPage;


    @Given("I am on the HomePage")
    public void i_am_on_the_home_page() {
        homePage = new HomePage(driver);
    }
    @When("I click on Account Button")
    public void i_click_on_account_button() {
        homePage.clickAccount();
    }
    @When("I click on Sign In and I am on Sign In page")
    public void i_click_on_sign_in_and_i_am_on_sign_in_page() {
        signInPage=new SignInPage(driver);
       homePage.clickOnSignIn();
    }
    @When("I Enter {string} and {string}")
    public void iEnterAnd(String eMail, String pwd) {
        signInPage.signIn(eMail,pwd);

    }
    @When("I click on Sign In Button")
    public void i_click_on_sign_in_button() {
        signInPage.clikOnSignIn();
    }
    @When("I goto Women page and select subCategory")
    public void i_goto_women_page_and_select_sub_category() {
        womenPage = new WomenPage(driver);
        womenPage.selectCategorypage();
    }
    @When("I add three products to Cart")
    public void i_add_three_products_to_cart() {
        womenPage.addProductsToCart();

    }
    @When("I goto Cart")
    public void i_goto_cart() {
        cartPage = new CartPage(driver);
        womenPage.clickCartIcon();
    }
    @Then("I Verify the add Products present in Cart")
    public void i_verify_the_add_products_present_in_cart() {
      cartPage.verifyCartItems();
        Assert.assertEquals(womenPage.actualAddCartitems,cartPage.ExceptedCartitems);
    }
    @When("I click on Sign Out")
    public void i_click_on_sign_out() {

        cartPage.signOut();
    }



}
