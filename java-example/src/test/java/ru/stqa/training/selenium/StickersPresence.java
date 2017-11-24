package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by gpodmorina on 02.11.2017.
 */
public class StickersPresence extends TestBase {

  @Test
  public void stickersPresence() {
    wd.get("http://localhost/litecart/");
    List<WebElement> productList = wd.findElements(By.xpath("//li[contains(@class, 'product')]"));
    for (int i = 0; i < productList.size(); i++) {
      List<WebElement> stickerList = productList.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]"));
      Assert.assertTrue(stickerList.size() == 1);
    }
  }
}
