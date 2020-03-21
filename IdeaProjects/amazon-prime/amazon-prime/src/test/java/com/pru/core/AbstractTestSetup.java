package com.pru.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestSetup {

  //  public static final String CROME_DRIVER_PATH = "C:\\Users\\farhana rashid\\IdeaProjects\\AmazonPrime\\Amazon\\Driver\\chromedriver.exe";
  private static final String CHROME_DRIVER_PATH = "C:\\Users\\farhana rashid\\IdeaProjects\\Driver\\chromedriver.exe";
  protected WebDriver driver;

  @Parameters({"browserName"})
  @BeforeMethod
  public void setup(@Optional("chrome") final String browserName) {
    initializeLocalDriver(browserName);
    driver.get(getUrl());
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  abstract protected String getUrl();

  private void initializeLocalDriver(final String browserName) {
    if (browserName.equalsIgnoreCase("chrome")) {
      System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
      ChromeOptions chromeOptions = new ChromeOptions();
      driver = new ChromeDriver(chromeOptions);
    } else if (browserName.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }

  public String selectOptionByVisibleText(WebElement element, String value) {
    Select select = new Select(element);
    select.selectByVisibleText(value);
    return value;
  }

  @AfterMethod
  public void close() {
    driver.quit();
  }
}
