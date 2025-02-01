package com.org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") //MyAccount Page Heading
    WebElement msgHeading;

    @FindBy(linkText ="Logout")
    WebElement btnLogout;

    public boolean isMyAccountPageExists()
    {
        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout()
    {
        btnLogout.click();
    }
}
