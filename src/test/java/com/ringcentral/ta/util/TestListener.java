package com.ringcentral.ta.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import static com.ringcentral.ta.util.LoggerHandler.logStep;

/**
 * Created by andy.lai on 2015/9/29.
 */
public class TestListener extends TestListenerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);
    public static final String CLASS_NAME = "TestListener";
    @Override
    public void onTestStart( ITestResult tr )
    {
        logStep(LOG, CLASS_NAME, 1, "TestListener start");
        System.out.println("SequoiaLoginTest listener start");
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log(callMethodName+"__"+callClassName+"__"+callDescription);
        Reporter.log("SequoiaLoginTest listener start");
    }
    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("SequoiaLoginTest listener success");
        String callMethodName = tr.getName();
        String callClassName = tr.getTestClass().getName();
        String callDescription = tr.getMethod().getDescription();
        Reporter.log("success");
        Reporter.log(callMethodName+"__"+callClassName+"__"+callDescription);

    }

}
