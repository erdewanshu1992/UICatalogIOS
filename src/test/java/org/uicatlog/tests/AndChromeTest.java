package org.uicatlog.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseForWebAndTest;

public class AndChromeTest extends BaseForWebAndTest {

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("🚀 Starting Chrome Test Suite...");
    }

    @BeforeClass
    public void navigateToWebsite() {
        driver.get("https://credit.com/");
    }

    @Test
    public void sampleTest() {
        System.out.println("🌐 Current URL: " + driver.getCurrentUrl());
        System.out.println("🌍 Page Title: " + driver.getTitle());
    }

}
