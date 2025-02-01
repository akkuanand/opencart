package com.org.testCases;

import com.org.pageObjects.AccountRegistrationPage;
import com.org.pageObjects.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_AccountRegistrationTest extends BaseClass{

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement lnkRegister;

        @Test(groups = {"Regression","Master"})
        public void verifyAccountRegistration()
        {
            logger.info("----Starting TC001_AccountRegistrationTest----");
            try {
                HomePage homePage = new HomePage(driver);

                logger.info("Clicking MyAccount Link");
                homePage.clickMyAccount();

                logger.info("Clicking Register Link");
                homePage.clickRegister();

                AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
                //registrationPage.setFirstName("john");

                logger.info("Entering Customer details");
                registrationPage.setFirstName(randomString().toUpperCase());

                //registrationPage.setLastName("Doe");
                registrationPage.setLastName(randomString().toUpperCase());

                //registrationPage.setEmail("abc@gmail.com");

                //Randomly generated Email
                registrationPage.setEmail(randomString() + "@gmail.com");

                //registrationPage.setTelephone("800917872");
                registrationPage.setTelephone(randomNumber());

                String password = randomAlphaNumeric();
                //registrationPage.setPassword("abc1234");
                registrationPage.setPassword(password);
                registrationPage.confirmPassword(password);
                registrationPage.setPolicy();
                registrationPage.clickContinue();

                logger.info("Validating Success Message for Account Creation...");
                String confMsg = registrationPage.getConfirmationText();
                if(confMsg.equals("Your Account Has Been Created!"))
                {
                    Assert.assertTrue(true);
                }
                else {
                    logger.error("Test Failed");
                    logger.debug("Debug Logs....");
                    Assert.assertTrue(false);
                }
                //Assert.assertEquals(confMsg, "Your Account Has Been Created!");
            }
            catch(Exception e)
            {
                Assert.fail();
            }
            logger.info("Test is Finished");
        }
}
