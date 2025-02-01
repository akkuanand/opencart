package com.org.testCases;

import com.org.pageObjects.HomePage;
import com.org.pageObjects.LoginPage;
import com.org.pageObjects.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginTest extends BaseClass{

    @Test(groups = {"Sanity","Master"})
    public void verifyLogin()
    {
        logger.info("-----Starting TC002_LOGIN Test-----");

        try {
            //HomePage
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            //Login Page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailAddress(p.getProperty("email"));
            loginPage.setPassword(p.getProperty("password"));
            loginPage.login();

            //MyAccount Page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();
            Assert.assertTrue(targetPage, "Login Failed");
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("---Finished TC0002----");
    }
}
