package com.ringcentral.ta.util;

import com.ringcentral.ta.config.Brand;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindHelper {
    public static WebElement findElemByNameWithWait(AppiumDriver appiumDriver, String name, long timeOutInSeconds) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, timeOutInSeconds);
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        return appiumDriver.findElement(By.name(name));
    }

    public static WebElement findElemByNameWithWait(AppiumDriver appiumDriver, String name){
        return findElemByNameWithWait(appiumDriver,name,5);
    }

    public static WebElement findElemByIdWithWait(AppiumDriver appiumDriver, String id, long timeOutInSeconds) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, timeOutInSeconds);
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return appiumDriver.findElement(By.id(id));
    }

    public static WebElement findElemByIdWithWait(AppiumDriver appiumDriver, String id){
        return findElemByIdWithWait(appiumDriver,id,5);
    }

    public static WebElement findElemById(AppiumDriver appiumDriver, String id) {
        return appiumDriver.findElement(By.id(completeId(id)));
    }

    public static WebElement findNativeElemByIdWithWait(AppiumDriver appiumDriver, String id, long timeOutInSeconds) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, timeOutInSeconds);
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return appiumDriver.findElement(By.id(id));
    }

    public static WebElement findNativeElemById(AppiumDriver appiumDriver, String id) {
        return appiumDriver.findElement(By.id(id));
    }

    public static WebElement findElemByName(AppiumDriver appiumDriver, String name) {
        return appiumDriver.findElement(By.name(name));
    }

    public static WebElement findElemByNameWithScroll(AppiumDriver appiumDriver, String name) {
        return appiumDriver.scrollTo(name);
    }

    public static WebElement findChildElemByClassName(WebElement parentElem, String className) {
        return parentElem.findElement(By.className(className));
    }

    public static WebElement findElemByXpath(AppiumDriver appiumDriver, String xpath) {
        return appiumDriver.findElement(By.xpath(xpath));
    }

    private static String completeId(String id) {
        return Brand.getPackageNameByBrand() + ":id/" + id;
    }
}
