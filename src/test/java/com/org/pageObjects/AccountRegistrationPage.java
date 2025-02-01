package com.org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
    WebDriver driver;
    public AccountRegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;

    @FindBy(id="input-lastname")
    WebElement txtLastName;

    @FindBy(id="input-email")
    WebElement txtEmail;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(id="input-confirm")
    WebElement cnfPassword;

    @FindBy(id = "input-telephone")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstName(String fname)
    {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String telephoneNo)
    {
        txtTelephone.sendKeys(telephoneNo);
    }

    public void setPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public  void confirmPassword(String password)
    {
        cnfPassword.sendKeys(password);
    }

    public void setPolicy()
    {
        //Actions act=new Actions(driver);
        //act.moveToElement(chkPolicy).click().perform();

        chkPolicy.click();
    }

    public void clickContinue()
    {
        btnContinue.click();
    }

    public String getConfirmationText()
    {
        try
        {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
