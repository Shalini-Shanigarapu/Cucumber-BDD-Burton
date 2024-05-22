package com.learn.pages;

import com.learn.utilties.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;
    private PerformActions performActions;
    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
    }

    @FindBy(xpath = "//input[contains(@id,'dwfrm_login_username')]")
    private WebElement eMailInputField;
    @FindBy(xpath = "//input[contains(@id,'dwfrm_login_password')]")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[contains(@id,'dwfrm_login_login')]")
    private WebElement signInButton;



    public void signIn(String eMail,String pwd) {
        performActions.typeValues(eMailInputField, eMail);
        performActions.typeValues(passwordInputField, pwd);
    }
    public void clikOnSignIn(){
        performActions.clickOnElement(signInButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
