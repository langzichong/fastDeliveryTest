package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class MyProfilePage extends Page {
    /**
     *  name
     */
    public static final String LOGOUT_NAME = "Logout";

    public MyProfilePage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getLogout() {
        return FindHelper.findElemByNameWithScroll(mobileDevice.getAppiumDriver(), LOGOUT_NAME);
    }
}
