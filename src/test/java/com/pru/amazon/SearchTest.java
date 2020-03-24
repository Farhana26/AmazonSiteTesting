package com.pru.amazon;

import com.pru.core.AbstractTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static com.pru.core.DatabaseConnection.getDatabaseConnection;

public class SearchTest extends AbstractTestSetup {


  @Test
  public void testSearch() throws SQLException, ClassNotFoundException, InterruptedException {
    final List<String> items = getDatabaseConnection().getItems();
    for (String item : items) {
      final WebElement searchField = getDriver().findElement(By.name("field-keywords"));
      searchField.clear();
      searchField.sendKeys(item);
      searchField.submit();
      Thread.sleep(1000);
    }
  }


  @Override
  protected String getUrl() {
    return "https://www.amazon.com";
  }
}
