package practice.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import practice.utils.WebDriverManagerUtil;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManagerUtil.getDriver();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManagerUtil.quitDriver();
    }
}
