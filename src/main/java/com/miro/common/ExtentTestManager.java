package com.miro.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Abdul Wahid.
 */
public class ExtentTestManager {
    public static ExtentTest test = null;
    public static SimpleDateFormat dtf = null;

    public static ExtentTest getTest() {
        return test;
    }

    public static void startTest(String testName) {
        test = BaseTest.extent.createTest(testName).log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case Started", ExtentColor.GREEN));
    }

    public static void startTest(String testName, String desc) {
        test = BaseTest.extent.createTest(testName, desc);
        test.log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case Started", ExtentColor.GREEN));
    }

    public static void endTest() {
        test.log(Status.PASS, MarkupHelper.createLabel(" Test Case ended", ExtentColor.GREEN));
    }

    public static void childTest(String chTest) {
        test.createNode(chTest).log(Status.INFO, "i m child");
    }

    public static void assignCategory(String categoryName) {
        ExtentTestManager.getTest().assignCategory(categoryName);
    }

    public static void assignCategory(String categoryName,String className) {
        ExtentTestManager.getTest().assignCategory(categoryName);
    }

    public static void assignAuthor() {
        ExtentTestManager.getTest().assignAuthor(System.getProperty("user.name"));
    }


    public static void captureScreenshot(WebDriver driver) {
        SimpleDateFormat dtf = new SimpleDateFormat("dd_MM_yyyy");
        Date date = new Date();
        String dateTime = dtf.format(date);

        //log.info(" : CaptureScreeshot Method Called");
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String dest = "D:\\DemoProject\\screenshots\\screenshotName_"+dateTime+".png";

            System.out.print(dest);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            //com.miro.common.ExtentTestManager.getTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
            ExtentTestManager.getTest().addScreenCaptureFromPath(dest);
            //MediaEntityBuilder.createScreenCaptureFromPath(dest).build();


        } catch (Exception ex) {
            //log.error(ex.getMessage());
            ex.printStackTrace();
            // return ex.getMessage();
        }
    }

}
