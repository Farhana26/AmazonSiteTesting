package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestSetup {

    @Test

    public void login()
    {
        driver.findElement(By.className("nav-action-button")).click();
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
