package com.org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement txtEmailAddress;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    public void setEmailAddress(String emailAddress)
    {
        txtEmailAddress.sendKeys(emailAddress);
    }

    public void setPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void login()
    {
        btnLogin.click();
    }

}
