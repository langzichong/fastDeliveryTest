package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class EditMessagePage extends Page {
    /**
     * ID
     */
    public static final String FORWARD_BTN_ID = "forward_sms_btn";
    public static final String DELETE_BTN_ID = "delete_sms_btn";

    public EditMessagePage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getForwardBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), FORWARD_BTN_ID);
    }

    public WebElement getDeleteBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), DELETE_BTN_ID);
    }

    public WebElement scrollToThreadByText(String containedText) {
        return FindHelper.findElemByNameWithScroll(mobileDevice.getAppiumDriver(), containedText);
    }
}
