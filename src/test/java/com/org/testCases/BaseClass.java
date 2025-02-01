package com.org.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"Sanity","Master","Regression"})
    @Parameters({"os","browser"})
    public void setUp(@Optional String os, String browser) throws IOException {
        //Loading config.properties file
        FileReader file=new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());

        switch(browser.toLowerCase())
        {
            case "chrome" :
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                logger.info("Configuration for "+browser+" is missing");
                driver=new ChromeDriver();
                return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://tutorialsninja.com/demo/");
        driver.get(p.getProperty("appURL"));//Reading URL from Properties File
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity","Master","Regression"})
    public void tearDown()
    {
        driver.close();
    }

    public String randomString()
    {
        String randomString= RandomStringUtils.randomAlphabetic(5);
        return randomString;
    }

    public String randomNumber()
    {
        String randomNumber=RandomStringUtils.randomNumeric(10);
        return randomNumber;
    }

    public String randomAlphaNumeric()
    {
        String randomAlphaNumeric=RandomStringUtils.randomAlphabetic(4)+RandomStringUtils.randomNumeric(5);
        return randomAlphaNumeric;
    }

    public String captureScreen(String tname) throws IOException
    {
        String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }

}
