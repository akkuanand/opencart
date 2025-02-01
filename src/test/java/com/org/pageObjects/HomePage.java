package com.org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement lnkRegister;

    @FindBy(linkText = "Login")
    WebElement lnkLogin;

    public void clickMyAccount()
    {
        lnkMyAccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        lnkLogin.click();
    }
}
