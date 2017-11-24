package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class BrowserLogs extends TestBase {

  @Before
  public void loginAdminLitecart() {
    wd.get("http://localhost/litecart/admin/");
    wd.findElement(By.name("username")).click();
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
  }

  @Test
  public void browserLogs() {
    wd.findElement(By.linkText("Catalog")).click();
    wd.findElement(By.linkText("Rubber Ducks")).click();
    List<WebElement> productLinks = wd.findElements(By.cssSelector("tr.row"));
    for (int i=4; i < productLinks.size(); i++) {
      List<WebElement> productLink = wd.findElements(By.cssSelector("tr.row"));
      productLink.get(i).findElement(By.xpath(".//a")).click();
      for (LogEntry l : wd.manage().logs().get("browser").getAll()) {
        System.out.println(l);
      }
      wd.findElement(By.linkText("Catalog")).click();
      wd.findElement(By.linkText("Rubber Ducks")).click();
    }
  }
}
