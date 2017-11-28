package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MainPage extends Page {

  public MainPage(WebDriver wd) {
    super(wd);
  }

  public MainPage open() {
    wd.get("http://localhost/litecart/");
    wait.until(titleIs("Online Store | My Store"));
    return this;
  }

  public void openProduct() {
    wd.findElement(By.cssSelector("li.product")).click();
  }

  public void openBusket() {
    wd.findElement(By.linkText("Checkout »")).click();
  }
}
