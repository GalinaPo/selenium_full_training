package ru.stqa.training.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

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
    List<WebElement> linksList = wd.findElements(By.cssSelector("a[target='_blank']"));
    for (WebElement link : linksList) {
      String mainWindow = wd.getWindowHandle();
      Set<String> oldWindows = wd.getWindowHandles();
      link.click();
      String newWindow = wait.until(anyWindowOtherThan(oldWindows));
      wd.switchTo().window(newWindow);
      wd.close();
      wd.switchTo().window(mainWindow);
    }
  }

  public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
    return new ExpectedCondition<String>() {
      public String apply(WebDriver wd) {
       Set<String> handles = wd.getWindowHandles();
       handles.removeAll(oldWindows);
       return handles.size() > 0 ? handles.iterator().next() : null;
      }
    };
  }
}
