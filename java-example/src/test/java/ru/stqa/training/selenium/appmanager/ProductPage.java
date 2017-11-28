package ru.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

  public ProductPage(WebDriver wd) {
    super(wd);
  }

  public void selectSizeIfNeed() {
    if (isElementPresent(By.name("options[Size]"))) {
      wd.findElement(By.xpath("//option[not(@selected)]")).click();
    }
  }

  public void addProductToBusket() {
    wd.findElement(By.name("add_cart_product")).click();
  }
}
