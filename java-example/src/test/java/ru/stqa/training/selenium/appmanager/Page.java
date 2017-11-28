package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

  protected WebDriver wd;
  protected WebDriverWait wait;

  public Page(WebDriver driver) {
    this.wd = driver;
    wait = new WebDriverWait(driver, 10);
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
