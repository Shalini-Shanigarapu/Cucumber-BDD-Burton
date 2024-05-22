package com.learn.StepDefinitions;

import com.learn.base.Base;
import io.cucumber.java.*;
import org.testng.annotations.*;


public class Hooks {
    @Before
    public static void initializeBrowser() {
        Base.initializeBrowser();
        Base.launchApplication();
    }
    @After
    public static void tearDown(){
        Base.closeBrowser();
    }
}

