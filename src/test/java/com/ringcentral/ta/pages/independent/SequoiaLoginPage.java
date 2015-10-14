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

public class SequoiaLoginPage extends Page {
    private static final Logger LOG = LoggerFactory.getLogger(SequoiaLoginPage.class);
    public static final String CLASS_NAME = "SequoiaLoginPage";
    private static ThreadLocal<SequoiaLoginPage> instance = new ThreadLocal<SequoiaLoginPage>();

    public static SequoiaLoginPage get(MobileDevice mobileDevice) {
        if (instance.get() == null) {
            instance.set(new SequoiaLoginPage(mobileDevice));
        }
        return instance.get();
    }

    public SequoiaLoginPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public void setPhoneNumber(String name){
        findElemByIdWithWait(mobileDevice.getAppiumDriver(), "edtPhoneNumber").sendKeys(name);
        logStep(LOG, CLASS_NAME,"enter phone number");
    }

    public void setExtension(String extensionNum){
        findElemByIdWithWait(mobileDevice.getAppiumDriver(), "edtExtension",5).sendKeys(extensionNum);
        logStep(LOG, CLASS_NAME, "enter extension Info");
    }
    public void setPassword(String password){
        findElemByIdWithWait(mobileDevice.getAppiumDriver(), "edtPassword",5).sendKeys(password);
        logStep(LOG, CLASS_NAME,"enter password");
    }
    public void clickLogin(){
        findElemByIdWithWait(mobileDevice.getAppiumDriver(),"btnLogin",5).click();
        logStep(LOG, CLASS_NAME,"click Login xiaup");
    }
    public void clickLoginProduction(){
        findElemByIdWithWait(mobileDevice.getAppiumDriver(),"btnLogin2",5).click();
        logStep(LOG, CLASS_NAME,"click Login production");
    }
}
