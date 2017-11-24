package ru.stqa.training.selenium;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpodmorina on 01.11.2017.
 */
public class TestBase {

  //public EventFiringWebDriver wd;
  public WebDriver wd;
  public WebDriverWait wait;

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by +  " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
      File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screen = new File("screen-" + System.currentTimeMillis() + ".png");
      try {
        Files.copy(tempFile, screen);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(screen);
    }
  }

  @Before
  public void start() {
    //wd = new EventFiringWebDriver(new ChromeDriver());
    //wd.register(new MyListener());
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 10);
  }

  @After
  public void stop() {
    wd.quit();
  }
}
