package org.uicatlog.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseForWebMiOSTest;

public class SafariTest extends BaseForWebMiOSTest {

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("🚀 Starting Safari Test Suite...");
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
