package com.ringcentral.ta.pages.nativepage.contact;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class NativeNewContactPage extends Page{
    public static final String EDIT_CONTACT_ACTIVITY_NAME = "ContactEditorActivity";

    /**
     * name
     */
    public static final String NAME = "Name";

    /**
     * id
     */
    public static final String SAVE_BTN_ID = "com.android.contacts:id/menu_done";

    /**
     * xpath
     */
    public static final String MOBILE_PHONE_XPATH = "//android.widget.EditText[@text='Phone number']";

    public NativeNewContactPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    //Todo: It shows 'RecentsActivity' when switching from recent menu list, so it is unreliable sometime.
    // Android only
    public void waitForActivity(long timeSeconds) throws InterruptedException {
        while (timeSeconds-- > 0) {
            if (((AndroidDriver)mobileDevice.getAppiumDriver()).currentActivity().contains(EDIT_CONTACT_ACTIVITY_NAME))
                return;
            else
                Thread.sleep(1000);
        }
    }

    public WebElement getNameField() {
        return FindHelper.findElemByName(mobileDevice.getAppiumDriver(), NAME);
    }

    public WebElement getPhoneField() {
        return FindHelper.findElemByXpath(mobileDevice.getAppiumDriver(), MOBILE_PHONE_XPATH);
    }

    public WebElement getSaveBtn() {
        return FindHelper.findNativeElemById(mobileDevice.getAppiumDriver(), SAVE_BTN_ID);
    }
}
