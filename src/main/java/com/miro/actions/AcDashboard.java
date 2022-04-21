package com.miro.actions;

import com.aventstack.extentreports.Status;
import com.miro.common.ExtentTestManager;
import com.miro.common.SeleniumWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AcDashboard {


    public static void renameBoard(WebDriver driver) {
        String xpath = "//div[@data-testid=\"dashboard__grid__context-button\"]";
        String xpathOverlay = "//div[@class=\"board-brick__preview__overlay\"]";
        Actions action = new Actions(driver);
        String xpathRename = "//div[@data-testid=\"rename_board_action\"]";


        // WebElement elementOverlay = SeleniumWait.elementWait(driver,xpathOverlay);
        WebElement elementOverlay = driver.findElement(By.xpath(xpathOverlay));

        Actions a = action.moveToElement(elementOverlay);
        WebElement element = driver.findElement(By.xpath(xpath));
        a.moveToElement(element).click();

        WebElement rename = driver.findElement(By.xpath(xpathRename));
        rename.click();

    }

    public static void enterName(WebDriver driver, String name) {
        String xpath = "//input[@data-testid=\"rename-board-modal__name-input\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(name);
    }

    public static void clickRenameOK(WebDriver driver) {
        String xpath = "//button[@data-testid=\"rename-board-modal__submit-button\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public static void openBoard(WebDriver driver, String name) {
        String xpath = "//span[text()='" + name + "']/../../..";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Open "+name+" board successfully");

    }

    public static void openMoreTools(WebDriver driver) {
        String xpath = "//div[@tooltip=\"more tools\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Open more loot from left tool box");
    }

    public static void searchTool(WebDriver driver, String tool) {
        String xpath = "//input[@class=\"rtb-input search-input__input library-search-input ng-pristine ng-valid ng-empty ng-touched\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("'arguments[0].value='"+tool+"'",element);*/

        Actions action = new Actions(driver);
        action.moveToElement(element).sendKeys(tool);
        element.sendKeys(tool);
    }

    public static void selectSearchedItem(WebDriver driver) {
        String xpath = "//div[@class=\"library-root__item AT__library--EMOJI_ICONS library-root__item--list\"]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on stickers icon successfully");
    }

    public static void clickStickerTab(WebDriver driver) {
        String xpath = "//div[text()='Stickers']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on stickers tab successfully");
    }

    public static void clickSharebutton(WebDriver driver) {
        String xpath = "//button[@data-testid='share-board-button']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on share button successfully");
    }
    public static void clickRenameSave(WebDriver driver) {
        String xpath = "//button[@data-testid='rename-board-modal__submit-button']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        ExtentTestManager.getTest().log(Status.PASS,"Clicked on Save button  successfully");
    }

    public static void createSticker(WebDriver driver) {
        String xpath = "//div[@class=\"stickers-pack__sticker-2-2E_\"]";
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        elements.get(1).click();
        ExtentTestManager.getTest().log(Status.PASS,"Created sticker on canvas successfully");
    }

    public static void renameNewBoard(WebDriver driver,String name) {
        String xpath = "//input[@data-testid='rename-board-modal__name-input']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(name);
        ExtentTestManager.getTest().log(Status.PASS,"Rename the new board successfully as "+name);
    }



}
