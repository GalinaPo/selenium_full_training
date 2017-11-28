package ru.stqa.training.selenium.tests;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpodmorina on 01.11.2017.
 */
public class TestBase {

  //public EventFiringWebDriver wd;
  public ApplicationManager app;
  public WebDriver wd;
  public WebDriverWait wait;



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
    app = new ApplicationManager();
  }


  @After
  public void stop() {
    app.quit();
  }
}
