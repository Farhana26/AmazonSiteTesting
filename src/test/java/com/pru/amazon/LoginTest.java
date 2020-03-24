package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestSetup {

    /*@Test(priority = 2)

    public void login()
    {
        driver.findElement(By.className("nav-action-button")).click();
        driver.findElement(By.id("ap_email")).sendKeys("aboni.heaven@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("aroni156");
        driver.findElement(By.id("signInSubmit")).click();
    }*/
    @Test(priority=1)
    public void mousehover() throws InterruptedException {
        WebElement searchBtn = driver.findElement(By.id("nav-link-accountList"));

        Actions action = new Actions(driver);
        action.moveToElement(searchBtn).click().build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("ap_email")).sendKeys("aboni.heaven@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("aroni156");
        driver.findElement(By.id("signInSubmit")).click();
    }




    @Override
    protected String getUrl() {
        return "https://www.amazon.com";
    }
}
