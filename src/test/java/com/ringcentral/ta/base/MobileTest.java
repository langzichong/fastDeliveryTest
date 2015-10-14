package com.ringcentral.ta.base;

import com.ringcentral.ta.util.Mobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.ringcentral.ta.util.LoggerHandler.logStep;

public class MobileTest {
    protected Logger LOG;
    protected String CLASS_NAME;
    protected IClass testClassName;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        testClassName = Reporter.getCurrentTestResult().getTestClass();
        CLASS_NAME = testClassName.getName();
        LOG = LoggerFactory.getLogger(CLASS_NAME);
        System.out.println("MobileTest init");
    }
    public void logTechinal(String message){
        logStep(LOG,testClassName.getTestName(),message);
    }
    public void logBusiness(int step,String message){
        logStep(LOG,testClassName.getTestName(),step,message);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("MobileTest uninit");
    }

    public Mobile getMobile() {
        return null;
    }

    public void assertTrue(boolean bool,String message){
        if(bool){
            logTechinal(message + ": Passed");
        }else
        {
            logTechinal(message + ": Failed");
        }

        Assert.assertTrue(bool,message);
    }
    public void assertEqual(Object actual,Object expected,String message){
        if((expected == null) && (actual == null)) {
            logStep(LOG,CLASS_NAME,message+": Invalid actual or expected");
        }
        if(expected != null) {
             if (expected.equals(actual)) {
                 logStep(LOG,CLASS_NAME,message+": Passed (Expected value = "+expected+"   Actual value = "+actual);
            }else{
                 logStep(LOG,CLASS_NAME,message+": Failed (Expected value = "+expected+"   Actual value = "+actual);
             }
        }
        Assert.assertEquals(actual,expected,message);
    }

}
