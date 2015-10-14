package com.ringcentral.ta.util;

import com.ringcentral.ta.account.Account;

public class CommonActions {
    public static void doLogin(Mobile mobile) {
            mobile.getLoginPage().getPhoneFieldWithWait(15).sendKeys(Account.MOBILE_ALL_EXT_SYS[0]);
            mobile.getLoginPage().getExtensionField().sendKeys(Account.MOBILE_ALL_EXT_SYS[1]);
            mobile.getLoginPage().getPasswordField().sendKeys(Account.MOBILE_ALL_EXT_SYS[2]);
            mobile.getLoginPage().getLoginBtn().click();
    }

    public static void doFirstLogin(Mobile mobile) {
        doLogin(mobile);
        mobile.getSummaryOfLegalTermsPage().getAcceptBtnWithWait(60).click();
        mobile.getEmergencyCallingDisclaimerPage().getAcceptBtn().click();
        mobile.getWelcomePage().getSkipBtnByIdWithWait(15).click();
        //todo: add cellular property in Mobile and DeviceConfig
//        if (mobile.hasCellular()) {
            mobile.getSetMobileDeviceNumberPage().getMobileDeviceNumberInput().sendKeys("12345678901");
            mobile.getSetMobileDeviceNumberPage().getSaveBtn().click();
//        }
    }

    public static void cleanUpTips(Mobile mobile) {
        mobile.getTips().getCloseBtn().click();
        mobile.getTitleBar().getTitleBarPhoto().click();
        mobile.getTips().getCloseBtn().click();
        mobile.getTitleBar().getTopLeftBtn().click();
        mobile.getTitleBar().getTitle().click();
        mobile.getMobileDevice().getAppiumDriver().navigate().back();
        mobile.getNavBar().getMoreBtn().click();
        mobile.getNavBar().getMoreBtn().click();
    }

    public static void doLoginKillTips(Mobile mobile) {
        doFirstLogin(mobile);
        cleanUpTips(mobile);
    }
}
