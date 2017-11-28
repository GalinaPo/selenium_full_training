package ru.stqa.training.selenium.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by gpodmorina on 25.10.2017.
 */
public class MyFirstTest extends TestBase {


  @Test
  public void myFirstTest() {
    wd.get("http://www.google.com/");
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.findElement(By.name("q")).sendKeys("webdriver");
    wd.findElement(By.name("btnK")).click();
    wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After
  public void stop() {
    wd.quit();
  }
}
