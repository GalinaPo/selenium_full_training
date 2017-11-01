package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by gpodmorina on 25.10.2017.
 */
public class MyFirstTest {

   public FirefoxDriver wd;

  @Before
  public void start() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void myFirstTest() {
    wd.get("http://www.google.com/");
  }

  @After
  public void stop() {
    wd.quit();
  }
}
