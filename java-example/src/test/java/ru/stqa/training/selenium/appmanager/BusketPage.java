package ru.stqa.training.selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BusketPage extends Page {

  public BusketPage(WebDriver wd) {
    super(wd);
  }

  public void removeProductFromBusket() {
    wd.findElement(By.name("remove_cart_item")).click();
  }

  public void checkEmptyBusket(){
    if (!isElementPresent(By.cssSelector("em"))) {
      wd.findElement(By.name("remove_cart_item")).click();
      Assert.assertTrue(isElementPresent(By.cssSelector("em")));
    }
  }

}
