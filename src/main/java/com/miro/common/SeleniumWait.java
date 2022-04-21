package com.miro.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {



    public static WebElement elementWait(WebDriver driver,String xpath){
        WebDriverWait wait  = new WebDriverWait(driver,10);
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
}
