package com.ringcentral.ta.pages.common;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class TitleBar extends Page{
    /**
     * ID
     */
    public static final String TITLE_BAR_PHOTO_ID = "title_bar_photo";
    public static final String TITLE_ID = "title";
    public static final String TOP_LEFT_BTN_ID = "btnTopLeftImage";
    public static final String TOP_RIGHT_BTN_ID = "btnTopRightImage";

    /**
     * TITLE
     */
    public static final String PERSONAL_CONTACT = "Personal Contacts";
    public static final String COMPANY_CONTACT = "Company Contacts";

    public TitleBar(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getTitleBarPhotoWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), TITLE_BAR_PHOTO_ID, timeOutInSeconds);
    }

    public WebElement getTitleBarPhoto() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), TITLE_BAR_PHOTO_ID);
    }

    public WebElement getTitle() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), TITLE_ID);
    }

    public WebElement getTopLeftBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), TOP_LEFT_BTN_ID);
    }

    public WebElement getTopRightBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), TOP_RIGHT_BTN_ID);
    }
}
