package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.util.CmdLineExecutor;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class EditContactArea {
    public final static String CONTACT_EDIT_TEXT = "android.widget.EditText";

    private WebElement element;
    private MobileDevice device;


    public EditContactArea(MobileDevice device, WebElement element) {
        this.device = device;
        this.element = element;
    }

    public void inputContactWithoutDeleting(String contactName) throws IOException, InterruptedException {
        getContactEditText().click();
        CmdLineExecutor.adbInputText(contactName);
        Thread.sleep(300);
        device.getAppiumDriver().sendKeyEvent(66);  //send return key
    }

    public WebElement getContactEditText() {
        return FindHelper.findChildElemByClassName(element, CONTACT_EDIT_TEXT);
    }
}
