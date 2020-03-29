package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverAccount extends AbstractTestSetup {

  @Test
  public void testHoveAccountNListsAndClickYourAccount() throws Exception {
    final Actions actions = new Actions(driver);

    WebElement accountNLists = driver.findElement(By.id("nav-link-accountList"));
    final Action mouseHoverAccountNLists = actions.moveToElement(accountNLists).build();
    mouseHoverAccountNLists.perform();

    WebElement yourAccount = driver.findElement(By.xpath("//a/span[text()='Your Account']"));
    final Actions clickYourAccount = actions.click(yourAccount);
    clickYourAccount.perform();

    Thread.sleep(5000);
  }

  @Override
  protected String getUrl() {
    return "https://www.amazon.com";
  }
}
