package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends AbstractTestSetup {

    @Test
    public void searchitem() throws InterruptedException {
        WebElement drop_down = driver.findElement(By.id("searchDropdownBox"));
        Select se = new Select(drop_down);
        List<WebElement> options = se.getOptions();
        List<String> items = new ArrayList<String>();
        for (WebElement i : options) {
            items.add(i.getText());
        }
        System.out.println("\n**********************  " + items);
        for (int j = 0; j < items.size() - 1; j++) {
            WebElement SearchBar = driver.findElement(By.id("twotabsearchtextbox"));
            SearchBar.clear();
            SearchBar.sendKeys(items.get(j));
            driver.findElement((By.className("nav-input"))).click();
            Thread.sleep(1000);
        }

    }

    @Override
    protected String getUrl() {
        return "https://www.amazon.com";
    }

}
