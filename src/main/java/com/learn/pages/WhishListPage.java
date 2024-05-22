package com.learn.pages;

import com.learn.utilties.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WhishListPage {
    private WebDriver driver;
    private PerformActions performActions;
    public List<String> ExceptedWishlistitems;
    public String ExceptedProductName;
    public WhishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
    }


    @FindBy(xpath = "//div[@class='product-list-product-details']/a")
    private List<WebElement> listOfProductsinWishList;
    @FindBy(xpath = "//div[@class='desktop-account-welcome-wrapper']/a[text()='Sign Out']")
    private WebElement signOutLink;



    public void verifywishListItems(){
        ExceptedWishlistitems=new ArrayList<>();
        for(WebElement element:listOfProductsinWishList){
            ExceptedProductName=element.getText();
            ExceptedWishlistitems.add(ExceptedProductName);
        }
        Collections.sort(ExceptedWishlistitems);
        System.out.println("Excepted WhitelistItems"+ ExceptedWishlistitems);
    }
    public void signOut(){
        performActions.clickElementWithActions(signOutLink);
    }


    }




