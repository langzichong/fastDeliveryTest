package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.aop.Action;
import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.pages.common.TitleBar;
import com.ringcentral.ta.util.CommonFinder;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import static com.ringcentral.ta.util.FindHelper.*;
import static com.ringcentral.ta.util.LoggerHandler.logStep;

public class SequoiaMainPage extends Page {
    private static final Logger LOG = LoggerFactory.getLogger(SequoiaMainPage.class);
    public static final String CLASS_NAME = "SequoiaMainPage";
    private static ThreadLocal<SequoiaMainPage> instance = new ThreadLocal<SequoiaMainPage>();

    public static SequoiaMainPage get(MobileDevice mobileDevice) {
        if (instance.get() == null) {
            instance.set(new SequoiaMainPage(mobileDevice));
        }
        return instance.get();
    }

    public SequoiaMainPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public boolean isSequoiaMainPageDisplayed(){
        logStep(LOG, CLASS_NAME, "Is Sequoia MainPage Displayed");
        return findElemByIdWithWait(mobileDevice.getAppiumDriver(), "menu_messages_logout",5).isDisplayed();

    }

    public int getMessageboxCount(){
        logStep(LOG, CLASS_NAME, "get Messagebox count");
        return mobileDevice.getAppiumDriver().findElementsById("txtConversationId").size();
    }
}
