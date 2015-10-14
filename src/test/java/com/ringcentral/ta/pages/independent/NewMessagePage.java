package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class NewMessagePage extends Page {
    /**
     * ID
     */
    public static final String MESSAGE_EDITTEXT_ID = "message_edittext";
    public static final String EDIT_CONTACT_AREA_ID = "edit_contact_area";
    public static final String SEND_BTN_ID = "send_sms_btn";

    public NewMessagePage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public EditContactArea getEditContactArea() {
        return new EditContactArea(mobileDevice, FindHelper.findElemById(mobileDevice.getAppiumDriver(), EDIT_CONTACT_AREA_ID));
    }

    public WebElement getMessageEditText() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), MESSAGE_EDITTEXT_ID);
    }

    public WebElement getSendBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), SEND_BTN_ID);
    }
}
