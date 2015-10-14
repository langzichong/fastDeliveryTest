package com.ringcentral.ta.pages.common;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class NavBar extends Page{
    /**
     * NAME
     */
    public static final String MESSAGES_NAME = "Messages";
    public static final String CALLLOG_NAME = "Call Log";
    public static final String CONTACTS_NAME = "Contacts";
    public static final String DIALPAD_NAME = "Dial Pad";
    public static final String CONFERENCING_NAME = "Conferencing";
    public static final String MEETINGS_NAME = "Meetings";
    public static final String DOCUMENTS_NAME = "Documents";
    public static final String NEWTEXT_NAME = "New Text";
    public static final String FAVORITES_NAME = "Favorites";
    public static final String NEWFAX_NAME = "New Fax";

    /**
     * ID
     */
    public static final String MORE_ID = "layout_plus";

    public NavBar(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getContactsTab() {
        return FindHelper.findElemByName(mobileDevice.getAppiumDriver(), CONTACTS_NAME);
    }

    public WebElement getContactsTabWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByNameWithWait(mobileDevice.getAppiumDriver(), CONTACTS_NAME, timeOutInSeconds);
    }

    public WebElement getMoreBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), MORE_ID);
    }

    public WebElement getMoreBtnWithWait(long timeOutInSeconds) {
        return  FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), MORE_ID, timeOutInSeconds);
    }

    public WebElement getMessagesTab() {
        return FindHelper.findElemByName(mobileDevice.getAppiumDriver(), MESSAGES_NAME);
    }

    public WebElement getMessagesTabWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByNameWithWait(mobileDevice.getAppiumDriver(), MESSAGES_NAME, timeOutInSeconds);
    }

    public WebElement getDialPadTab() {
        return FindHelper.findElemByName(mobileDevice.getAppiumDriver(), DIALPAD_NAME);
    }

    public WebElement getDialPadTabWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByNameWithWait(mobileDevice.getAppiumDriver(), DIALPAD_NAME, timeOutInSeconds);
    }
}
