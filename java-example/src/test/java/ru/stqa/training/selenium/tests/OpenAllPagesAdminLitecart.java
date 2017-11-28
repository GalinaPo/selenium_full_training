package ru.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by gpodmorina on 01.11.2017.
 */
public class OpenAllPagesAdminLitecart extends TestBase {

  //@Test
  public void openAllPagesAdminLitecart() {
    wd.get("http://localhost/litecart/admin/");
    wd.findElement(By.name("username")).click();
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
    List<WebElement> elements = wd.findElements(By.id("app-"));
    for (int i=0; i < elements.size(); i++) {
      List<WebElement> el = wd.findElements(By.id("app-"));
      el.get(i).findElement(By.tagName("a")).click();
      assertEquals(true, app.isElementPresent(By.xpath("//td[@id='content']//h1")));
      List<WebElement> el1 = wd.findElements(By.id("app-"));
      int count = 0;
      count = el1.get(i).findElements(By.xpath(".//ul[@class='docs']/li")).size();
      if (count > 0) {
        for (int j=0; j < count; j++) {
          List<WebElement> els = wd.findElements(By.xpath(".//ul[@class='docs']/li"));
          els.get(j).findElement(By.tagName("a")).click();
          assertEquals(true, app.isElementPresent(By.xpath("//td[@id='content']//h1")));
        }
      }
    }
  }
}
