package com.miro.web.test;

import com.aventstack.extentreports.Status;

import com.miro.actions.AcDashboard;
import com.miro.actions.AcLogin;
import com.miro.apiCalls.APIsCall;
import com.miro.common.BaseTest;
import com.miro.common.Common;
import com.miro.common.ExtentTestManager;
import com.miro.page.PgLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;

public class MiroAutomationTest extends BaseTest {

    @Test
    public void createSticker() {
        ExtentTestManager.startTest("createSticker", "Creating sticker on canvas ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        try {
            PgLogin.verifyUsername(driver);
            AcLogin.enterUsername(driver, username1);
            AcLogin.enterPassword(driver, password1);
            AcLogin.clickSignIn(driver);
            if (APIsCall.createBoard(driver)) {
                com.miro.common.ExtentTestManager.getTest().log(Status.PASS, "Board has been created");
            } else {
                com.miro.common.ExtentTestManager.getTest().log(Status.FAIL, "Board is not created");
            }
            Thread.sleep(5000);
            driver.navigate().refresh();
            Thread.sleep(5000);
            AcDashboard.openBoard(driver, "Untitled");
            Thread.sleep(2000);
            Thread.sleep(2000);
            AcDashboard.openMoreTools(driver);
            Thread.sleep(2000);
            //AcDashboard.searchTool(driver, "Stickers and Emojis");
            Thread.sleep(2000);
            AcDashboard.selectSearchedItem(driver);
            Thread.sleep(2000);
            AcDashboard.clickStickerTab(driver);
            Thread.sleep(2000);
            AcDashboard.createSticker(driver);
            Thread.sleep(2000);
            AcDashboard.clickSharebutton(driver);
            Thread.sleep(2000);
            AcDashboard.renameNewBoard(driver, "Board");
            Thread.sleep(2000);
            AcDashboard.clickRenameSave(driver);
            Thread.sleep(2000);
            APIsCall.invite("abdul.ali@globallogic.com");
            Thread.sleep(2000);
            Common.openNewTab(driver);
            driver.navigate().to(URL);
            Thread.sleep(2000);
            AcLogin.enterUsername(driver, username2);
            AcLogin.enterPassword(driver, password2);
            AcLogin.clickSignIn(driver);
            Thread.sleep(2000);
            AcDashboard.openBoard(driver, "Board");
            Thread.sleep(2000);
            Thread.sleep(2000);
            Thread.sleep(2000);
            Common.captureScreenshot(driver);
            ExtentTestManager.getTest().log(Status.PASS, "Passed");
            ExtentTestManager.endTest();
            driver.quit();

        } catch (Exception e) {
            Assert.fail();
            driver.quit();
        }

    }


}
