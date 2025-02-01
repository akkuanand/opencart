package com.org.testCases;

import com.org.pageObjects.HomePage;
import com.org.pageObjects.LoginPage;
import com.org.pageObjects.MyAccountPage;
import com.org.utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Data is Valid->Login Successful->Test Case Passed
Data is Valid->Login Failed->Test Case Failed
Data is Invalid->Login Successful->Test Case Failed
Data is Invalid->Login Failed->Test Case Passed
 */

public class TC003_LoginDDT extends BaseClass{

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Data-Driven") //getting Data Provider from different class
    public void verifyLoginDDT(String email, String pass, String result)
    {

        try {
            logger.info("-----Starting TC003_DDTLOGIN Test-----");
            //HomePage
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            //Login Page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailAddress(email);
            loginPage.setPassword(pass);
            loginPage.login();

            //MyAccount Page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();

            if (result.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    Assert.assertTrue(true);
                    myAccountPage.clickLogout();
                } else {
                    Assert.fail();
                }
            } else {
                if (result.equalsIgnoreCase("Invalid")) {
                    if (targetPage) {
                        myAccountPage.clickLogout();
                        Assert.fail();
                    } else {
                        Assert.assertTrue(true);
                    }
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("---Finished TC0002----");
}

}
