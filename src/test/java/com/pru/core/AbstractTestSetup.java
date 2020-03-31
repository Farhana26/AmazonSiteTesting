package com.pru.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestSetup {

  //  public static final String CROME_DRIVER_PATH = "C:\\Users\\farhana rashid\\IdeaProjects\\AmazonPrime\\Amazon\\Driver\\chromedriver.exe";
  private static final String CHROME_DRIVER_PATH = "C:\\Users\\farhana rashid\\IdeaProjects\\Driver\\chromedriver.exe";
//  private static final String CHROME_DRIVER_PATH = "/home/fasihul/Downloads/chromedriver_linux64/chromedriver";

  protected WebDriver driver;

  @Parameters({"browserName"})
  @BeforeMethod
  public void setup(@Optional("chrome") final String browserName) throws InterruptedException {
    initializeLocalDriver(browserName);
    driver.get(getUrl());
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    //login();
  }

 /* public void login() throws InterruptedException {
    WebElement searchBtn = driver.findElement(By.id("nav-link-accountList"));

    Actions action = new Actions(driver);
    action.moveToElement(searchBtn).click().build().perform();
    Thread.sleep(2000);
    driver.findElement(By.id("ap_email")).sendKeys("aboni.heaven@gmail.com");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("ap_password")).sendKeys("aroni156");
    driver.findElement(By.id("signInSubmit")).click();
  }*/

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
