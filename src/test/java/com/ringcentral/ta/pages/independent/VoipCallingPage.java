package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class VoipCallingPage extends Page {
    /**
     * ID
     */
    public static final String END_CALL_BTN = "btn_call_endcall";
    public static final String CALL_DURATION_FIELD = "voip_call_info_call_duration";

    public VoipCallingPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement getVoipCallDurationWithWait(long timeOutInSeconds) {
        return FindHelper.findElemByIdWithWait(mobileDevice.getAppiumDriver(), CALL_DURATION_FIELD, timeOutInSeconds);
    }

    public  WebElement getEndCallBtn() {
        return FindHelper.findElemById(mobileDevice.getAppiumDriver(), END_CALL_BTN);
    }
}
