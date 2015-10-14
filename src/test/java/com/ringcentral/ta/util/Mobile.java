package com.ringcentral.ta.util;

import com.ringcentral.ta.pages.common.NavBar;
import com.ringcentral.ta.pages.common.Tips;
import com.ringcentral.ta.pages.common.TitleBar;
import com.ringcentral.ta.pages.independent.*;
import com.ringcentral.ta.pages.nativepage.contact.NativeNewContactPage;
import io.appium.java_client.AppiumDriver;

public class Mobile {
    private MobileDevice mobileDevice;

    public Mobile(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;

    }

//    public static AppiumDriver setDriver() {
//    }

    public MobileDevice getMobileDevice() {
        return mobileDevice;
    }
    public AppiumDriver getAppiumDriver(){
        return mobileDevice.getAppiumDriver();
    }

    public void endSession() {
        getMobileDevice().getAppiumDriver().quit();
    }

    public NavBar getNavBar() {
        return new NavBar(mobileDevice);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(mobileDevice);
    }

    public SummaryOfLegalTermsPage getSummaryOfLegalTermsPage() {
        return new SummaryOfLegalTermsPage(mobileDevice);
    }

    public EmergencyCallingDisclaimerPage getEmergencyCallingDisclaimerPage() {
        return new EmergencyCallingDisclaimerPage(mobileDevice);
    }

    public WelcomePage getWelcomePage() {
        return new WelcomePage(mobileDevice);
    }

    public SetMobileDeviceNumberPage getSetMobileDeviceNumberPage() {
        return new SetMobileDeviceNumberPage(mobileDevice);
    }

    public Tips getTips() {
        return new Tips(mobileDevice);
    }

    public TitleBar getTitleBar() {
        return new TitleBar(mobileDevice);
    }

    public MyProfilePage getMyProfilePage() {
        return new MyProfilePage(mobileDevice);
    }

    public NewMessagePage getNewMessagePage() {
        return new NewMessagePage(mobileDevice);
    }

    public MessageThreadPage getMessageThreadPage() {
        return new MessageThreadPage(mobileDevice);
    }

    public CommonFinder getCommonFinder() {
        return new CommonFinder((mobileDevice));
    }

    public EditMessagePage getEditMessagePage() {
        return new EditMessagePage(mobileDevice);
    }

    public NativeNewContactPage getNativeNewContactPage() {
        return new NativeNewContactPage(mobileDevice);
    }

    public ContactsPage getContactsPage() {
        return new ContactsPage(mobileDevice);
    }

    public DialPadPage getDialPadPage() {
        return new DialPadPage(mobileDevice);
    }

    public VoipCallingPage getVoipCallingPage() {
        return new VoipCallingPage(mobileDevice);
    }

    public void sendKeyCode(int keyCode) {
        mobileDevice.getAppiumDriver().sendKeyEvent(keyCode);
    }

    public void back() {
        mobileDevice.getAppiumDriver().navigate().back();
    }

    public SequoiaLoginPage getSequoiaLoginPage(){
        return SequoiaLoginPage.get(mobileDevice);
    }
    public SequoiaMainPage getSequoiaMainPage(){
        return SequoiaMainPage.get(mobileDevice);
    }
}
