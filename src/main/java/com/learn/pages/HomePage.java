package com.learn.pages;

import com.learn.utilties.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private PerformActions performActions;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
    }

    @FindBy(xpath = "//span[contains(@class,'icon-account desktop')]")
    private WebElement accountButton;
    @FindBy(id = "onetrust-reject-all-handler")
    private WebElement dismissBtn;
    @FindBy(xpath = "//div[@id='account-nav-menu-content']//a[text()='Create an Account']")
    private WebElement selectCreateAccount;
    @FindBy(xpath = "//div[@id='account-nav-menu-content']//a[text()='Sign In']")
    private WebElement selectSignIn;


    public void clickAccount() {
        performActions.clickOnElement(dismissBtn);
        performActions.clickOnElement(accountButton);
    }
    public void clickOnCreateAccount(){
        performActions.clickElementWithActions(selectCreateAccount);
    }
    public void clickOnSignIn(){
        performActions.clickElementWithActions(selectSignIn);
    }


}
