package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BasePage {

    public Loginpage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInputBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputBox;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    public  void loginAsDriver(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
    public void loginAsSalesManager(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
