package com.selenium.sample.wrappers;


import com.selenium.sample.pageobjects.TestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TableTest {
    public static final String CHROME_DRIVER_PATH = "./src/test/resources/drivers/chromedriver.exe";
    public static final String SAMPLE_PAGE_PATH = "./src/test/resources/test_pages/sample_page_with_table.html";

    private WebDriver driver;
    private TestPage testPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test()
    public void test() {
        openSamplePage();

        TestPage testPage = new TestPage(driver);

        Assert.assertEquals(testPage.getCompanyContact("Island Trading"), "Helen Bennett");
        Assert.assertEquals(testPage.getCompanyCountry("Island Trading"), "UK");

        testPage.openWebsite("Island Trading");

        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        Assert.assertTrue(driver.getCurrentUrl().contains("Island"));
        Assert.assertTrue(driver.getCurrentUrl().contains("Trading"));
    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }

    private void openSamplePage() {
        driver.get(Paths.get(SAMPLE_PAGE_PATH).toUri().toString());
    }
}
