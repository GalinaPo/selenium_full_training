package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasketTest extends TestBase {

  @Test
  public void basketTest() throws InterruptedException {
    wd.get("http://localhost/litecart/");
    for (int i = 1; i < 4; i++) {
      wd.findElement(By.cssSelector("li.product")).click();
      if (isElementPresent(By.name("options[Size]"))) {
        wd.findElement(By.xpath("//option[not(@selected)]")).click();
      }
      wd.findElement(By.name("add_cart_product")).click();
      wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("a.content>span.quantity")), String.valueOf(i)));
      wd.get("http://localhost/litecart/");
    }
    wd.findElement(By.linkText("Checkout »")).click();
    for (int j = 1; j < 3; j++) {
      List<WebElement> itemsbefore = wd.findElements(By.cssSelector("td[style='text-align: center;']"));
      int numberItemsBefore = itemsbefore.size();
      wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item")));
      wd.findElement(By.name("remove_cart_item")).click();
      wait.until(ExpectedConditions.stalenessOf(wd.findElement(By.cssSelector("td[style='text-align: center;']"))));
      List<WebElement> itemsafter = wd.findElements(By.cssSelector("td[style='text-align: center;']"));
      int numberItemsAfter = itemsafter.size();
      Assert.assertEquals(numberItemsAfter, numberItemsBefore - 1);
    }
    if (!isElementPresent(By.cssSelector("em"))) {
      wd.findElement(By.name("remove_cart_item")).click();
      Assert.assertTrue(isElementPresent(By.cssSelector("em")));
    }
  }
}
