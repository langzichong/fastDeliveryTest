package com.ringcentral.ta.pages.common;

import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class Tips {
    /**
     * ID
     */
    public static final String CLOSE_BTN_ID = "btnClose";

    private MobileDevice mobileDevice;
    public Tips(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    public WebElement getCloseBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), CLOSE_BTN_ID);
    }
}
