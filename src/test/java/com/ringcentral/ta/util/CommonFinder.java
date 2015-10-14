package com.ringcentral.ta.util;

import com.ringcentral.ta.pages.base.Page;
import org.openqa.selenium.WebElement;

public class CommonFinder extends Page{

    public CommonFinder(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement findElemByText(String text) {
        return FindHelper.findElemByName(mobileDevice.getAppiumDriver(), text);
    }

    public WebElement findElemByTextWithWait(String text, long timeOutInSeconds) {
        return FindHelper.findElemByNameWithWait(mobileDevice.getAppiumDriver(), text, timeOutInSeconds);
    }
}
