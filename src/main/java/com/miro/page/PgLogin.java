package com.miro.page;

import com.aventstack.extentreports.ExtentTest;
import com.miro.common.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

public class PgLogin {

    public static void verifyUsername(WebDriver driver){
        String id = "email";
        WebElement element = driver.findElement(By.id(id));
        if(element.isEnabled()){
            ExtentTestManager.getTest().log(Status.PASS,"Username field is displaying as enabled");
        }
    }
}
