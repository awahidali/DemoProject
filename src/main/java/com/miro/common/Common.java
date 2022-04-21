package com.miro.common;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abdul Wahid
 */
public class Common {

    public static void openNewTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        ExtentTestManager.getTest().log(Status.PASS, "New blank tab opened successfully");
    }

    public static void captureScreenshot(WebDriver driver) {
        Date date = new Date();
        SimpleDateFormat dtf = new SimpleDateFormat("dd_MM_yyyy");
        String dateTime = dtf.format(date);
        TakesScreenshot ts = (TakesScreenshot) driver;
        String filePath = System.getProperty("user.dir") +"\\screenshots\\sticker_"+dateTime+".png";
        try {
            File src = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(filePath);
            FileUtils.copyFile(src, target);
            ExtentTestManager.getTest().log(Status.PASS, "Capture the visible sticker");
            ExtentTestManager.getTest().addScreenCaptureFromPath(filePath);
        } catch (Exception e) {
            ExtentTestManager.getTest().log(Status.FAIL, "Not Capture the visible sticker");
            Assert.fail();
        }
    }
}
