package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpeningLinksNewWindow extends TestBase  {

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
  public void openingLinksNewWindow() {
    wd.findElement(By.linkText("Countries")).click();
    wd.findElement(By.cssSelector("a[title='Edit']")).click();
    List<WebElement> elements = wd.findElements(By.cssSelector("a[target='_blank']"));
    for (int i = 0; i < elements.size(); i++) {
      List<WebElement> el = wd.findElements(By.cssSelector("a[target='_blank']"));
      el.get(i).findElement(By.cssSelector("a[target='_blank']")).click();
    }
  }
}
