package com.learn.pages;

import com.learn.utilties.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private PerformActions performActions;
    public List<String> ExceptedCartitems;
    public String ExceptedProductName;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
    }


    @FindBy(xpath = "//div[@class='item-details']/a")
    private List<WebElement> listOfProductsinCart;

    @FindBy(xpath = "//span[contains(@class,'icon-account desktop')]")
    private WebElement accountButton;
    @FindBy(xpath = "//div[@id='account-nav-menu-content']//a[text()='Sign Out']")
    private WebElement signOutLink;



    public void verifyCartItems(){
        ExceptedCartitems=new ArrayList<>();
        for(WebElement element:listOfProductsinCart){
            ExceptedProductName=element.getText();
            ExceptedCartitems.add(ExceptedProductName);
        }
        Collections.sort(ExceptedCartitems);
        System.out.println("Excepted WhitelistItems"+ ExceptedCartitems);
    }
    public void signOut(){
        performActions.clickOnElement(accountButton);
        performActions.clickElementWithActions(signOutLink);
    }


}

