package com.miro.actions;

import com.aventstack.extentreports.Status;
import com.miro.common.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcLogin {

    public static void enterUsername(WebDriver driver, String usn) {
        String id = "email";
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(usn);
        ExtentTestManager.getTest().log(Status.PASS,"Enter the Username successfully");
    }

    public static void enterPassword(WebDriver driver, String pass) {
        String id = "password";
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(pass);
        ExtentTestManager.getTest().log(Status.PASS,"Enter the password successfully");
    }

    public static void clickSignIn(WebDriver driver) {
        String xpath = "//button[@data-testid=\"mr-form-login-btn-signin-1\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Click on the sign in button successfully");
    }







}
