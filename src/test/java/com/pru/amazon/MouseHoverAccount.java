package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverAccount extends AbstractTestSetup {

  @Test
  public void mouseHover() throws InterruptedException {
    WebElement searchBtn = driver.findElement(By.id("nav-link-accountList"));

    Actions actions = new Actions(driver);
    //action.moveToElement(searchBtn).click().build().perform();
    actions.moveToElement(searchBtn);

    // action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("submenuxpath"))).click().build().perform();

    WebElement subMenu = driver.findElement(By.xpath("//span[@class=\"nav-text\"][text()='Your Account']"));
    actions.moveToElement(subMenu);
    actions.click().build().perform();
    Thread.sleep(2000);
    System.out.println("clicked");
  }

   /*public void mousehover(){
        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.linkText("menulink"));
        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(By.cssSelector("subLinklocator"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

    }*/

  @Override
  protected String getUrl() {
    return "https://www.amazon.com";
  }
}
