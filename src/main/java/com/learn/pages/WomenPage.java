package com.learn.pages;

import com.learn.utilties.PerformActions;
import com.learn.utilties.WaitHelper;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenPage {

    private WebDriver driver;
    private PerformActions performActions;
    private WaitHelper waitHelper;
    public List<String> actualWishlistitems;

    public List<String> actualAddCartitems;
    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'category-nav-column')]/span/a/span[text()='Women']")
    private WebElement womePagelink;
    @FindBy(xpath = "//u[text()='Shop Rain Jackets']")
    private WebElement subCategorylink;
    @FindBy(xpath = "//div[@class='product-list-grid-wrapper row product-grid-view']/article[@class='product-card']//div/figcaption/a/h2")
    private List<WebElement> listofProduts;
    private String productname;
    @FindBy(xpath = "//div[contains(@class,'product-detail-header-container')]/h1")
    private WebElement productnames;
    @FindBy(xpath = "//div[contains(@class,'variant-swatch-scroll-pane variationSize')]//a[@data-value='XS']")
    private WebElement selectSize;
    @FindBy(xpath = "//div[@class='wishlist-button-container']/button")
    private WebElement wishListBtn;
    @FindBy(xpath = "//div[contains(@class,'add-to-cart-button-container')]/button")
    private WebElement addCartBtn;

    @FindBy(xpath = "//button[text()='Select a Size']")
    private WebElement scrollToSize;
    @FindBy(xpath = " //div[@id='js-wishlist-counter-app']/a/span[contains(@class,'wishlist-counter__icon')]")
    private WebElement wishListIconbutton;
    @FindBy(xpath = "//div[contains(@class,'product-actions')]/button")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//div[contains(@class,'items-right col-lg-4')]/a[contains(@aria-label,'Proceed to Cart')]")
    private WebElement cartIcon;







    public void clickWishListIcon() {
        performActions.scrollToElement(wishListIconbutton);
        performActions.clickElementWithActions(wishListIconbutton);
    }
    public void clickCartIcon() {
        performActions.scrollToElement(cartIcon);
        performActions.clickElementWithActions(cartIcon);
    }

    public void selectCategorypage() {
        performActions.clickElementWithActions(womePagelink);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        performActions.hoverElementWithActions(subCategorylink);
        performActions.clickElementWithActions(subCategorylink);

    }
public void addWishListItems(){
    actualWishlistitems = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        WebElement product = listofProduts.get(i);
        performActions.clickElementWithActions(product);
        String productName = productnames.getText();
        actualWishlistitems.add(productName);
        performActions.scrollToElement(scrollToSize);
        performActions.clickElementWithActions(selectSize);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        performActions.clickElementWithActions(wishListBtn);
        driver.navigate().back();
    }
    Collections.sort(actualWishlistitems);
    System.out.println(actualWishlistitems);


}
public void addProductsToCart(){
    actualAddCartitems = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        WebElement product = listofProduts.get(i);
        performActions.clickElementWithActions(product);
        String productName = productnames.getText();
        actualAddCartitems.add(productName);
        performActions.scrollToElement(scrollToSize);
        performActions.clickElementWithActions(selectSize);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        performActions.clickElementWithActions(addCartBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        performActions.clickElementWithActions(continueShoppingBtn);
        driver.navigate().back();
    }
    Collections.sort(actualAddCartitems);
    System.out.println(actualAddCartitems);




}



}




