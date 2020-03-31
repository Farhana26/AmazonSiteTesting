package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestingMousehover extends AbstractTestSetup {
     @Test
            public void testdrop() {
         WebElement searchBtn = driver.findElement(By.id("nav-link-accountList"));
         Actions actions = new Actions(driver);
         //action.moveToElement(searchBtn).click().build().perform();
         actions.moveToElement(searchBtn);
         final List<WebElement> Elements = driver.findElements(By.xpath("//a[@class=\"nav-link nav-item\"]//span[@class=\"nav-text\"]"));
         // int count= Elements.size();
         //System.out.println(count);
         //List<WebElement> options = Elements.getClass();
         List<String> DropDownlist = new ArrayList<String>();
         for (WebElement element : Elements) {
             DropDownlist.add(element.getAttribute("innerText"));
             System.out.println(element.getAttribute("innerText"));
         }
        /* for (int j = 0; j < DropDownlist.size() - 1; j++) {
             if (Elements.get(j).getText().equalsIgnoreCase(DropDownlist.get(j))) {
                 //Elements.get(j).click();
               //  actions.moveToElement(Elements.get(j)).click().build().perform();
                 Thread.sleep(5000);
             }

             }*/
     }
    @Override
    protected String getUrl() {
        return "https://www.amazon.com";
    }

}

