package com.ringcentral.ta.test.sequoia;

import com.ringcentral.ta.base.SequoiaTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.ringcentral.ta.util.LoggerHandler.takeScreenShot;

/**
 * Created by andy.lai on 2015/9/28.
 */
public class SequoiaLoginTest extends SequoiaTest{


    @Test
    public void test_Sequoia_1() throws InterruptedException {

        logBusiness(1, "Login Sequoia ,enter correct phone number and password Info");
//        mobile.getSequoiaLoginPage().setPhoneNumber("18004330001");
//        mobile.getSequoiaLoginPage().setExtension("101");
//        mobile.getSequoiaLoginPage().setPassword("Test!123");
        mobile.getSequoiaLoginPage().clickLogin();
        assertTrue(mobile.getSequoiaMainPage().isSequoiaMainPageDisplayed(), "Check is SequoiaMainPageDisplayed");
        assertEqual(mobile.getSequoiaMainPage().getMessageboxCount(),3,"verify Messagebox count");
    }
    @Test
    public void test_CheckFirstMessageHistory() throws InterruptedException {
        logBusiness( 1, "enter correct phone number and password");
//        mobile.getSequoiaLoginPage().clickLogin();
        logBusiness( 1, "Select first Login page");
//        mobile.getMobileDevice().getAppiumDriver().findElementById("edtPhoneNumber").sendKeys("16507419631");
//        mobile.getMobileDevice().getAppiumDriver().findElementById("btnLogin2").click();

    }


}
