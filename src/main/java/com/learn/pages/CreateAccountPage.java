package com.learn.pages;

import com.learn.utilties.PerformActions;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CreateAccountPage {
    private WebDriver driver;
    private PerformActions performActions;
    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        performActions = new PerformActions(driver);
    }

    @FindBy(xpath = "//input[contains(@id,'dwfrm_profile_customer_firstname')]")
    private WebElement firstNameInputField;
    @FindBy(xpath = "//input[contains(@id,'dwfrm_profile_customer_lastname')]")
    private WebElement lastNameInputField;
    @FindBy(xpath = "//input[contains(@id,'dwfrm_profile_customer_email')]")
    private WebElement eMailInputField;
    @FindBy(xpath = "//input[contains(@id,'dwfrm_profile_customer_birthday')]")
    private WebElement DOBInputField;

    @FindBy(xpath = "//input[contains(@id,'dwfrm_profile_login_password')]")
    private WebElement createPasswordInputField;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_loyaltyoptin']/following::*[name()='svg' and @class='check-svg']")
    private WebElement termsCheckbox;



    @FindBy(xpath = "//button[@value='Create An Account']")
    private WebElement createAccountBtn;







    public void setFnLn() {
        String randomfn = RandomString.make();
        String firstName = randomfn;
        firstNameInputField.sendKeys(firstName);
        String randomln = RandomString.make();
        String lastName = randomln;
        lastNameInputField.sendKeys(lastName);
    }
    public void setEmail() {
        String randomMail = RandomString.make();
        String email = randomMail+"@yopmail.com";
        System.out.println(email);
        eMailInputField.sendKeys(email);

    }
    public void dateOfBirth(){
        Random random = new Random();
        int minyear=1900;
        int maxyear=2024;
        int year = random.nextInt(maxyear-minyear+1)+minyear;
        int month = random.nextInt(12)+1;
        int day;
        if(month==2){
            day=random.nextInt(29)+1;
        }else if(month==4 || month == 6 || month ==9||month==11){
            day=random.nextInt(30)+1;
        }else{
            day=random.nextInt(31)+1;
        }

        String formatDOB = month+"/"+day+"/"+year;
        DOBInputField.sendKeys(formatDOB);
        System.out.println("DOB: "+ formatDOB);


    }


    public void enterPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String splCharacters = "<>~!@#$%^&*)=_+-}]{[/?.,(";
        String combination = upper + lower + numbers + splCharacters;
        int length = 15;
        char[] password = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println("Random Generated Password: " + new String(password));
        WebElement RandomPassword = createPasswordInputField;
        RandomPassword.sendKeys(new String(password));
        System.out.println(new String(password));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickCreateAccount(){
        performActions.clickOnElement(termsCheckbox);
        performActions.clickOnElement(createAccountBtn);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
