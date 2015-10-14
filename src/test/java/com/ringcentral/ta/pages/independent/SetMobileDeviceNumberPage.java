package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class SetMobileDeviceNumberPage {
    /**
     * ID
     */
    public static final String PHONE_NUMBER_ID = "username_edit";
    public static final String SAVE_BTN_ID = "saveBtn";
    private MobileDevice mobileDevice;

    public SetMobileDeviceNumberPage(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    public WebElement getMobileDeviceNumberInput() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), PHONE_NUMBER_ID);
    }

    public WebElement getSaveBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), SAVE_BTN_ID);
    }
}
