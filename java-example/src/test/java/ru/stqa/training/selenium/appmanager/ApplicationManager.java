package ru.stqa.training.selenium.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  public WebDriver wd;
  public WebDriverWait wait;

  private MainPage mainPage;
  private ProductPage productPage;
  private BusketPage busketPage;

  public ApplicationManager() {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 10);
    mainPage = new MainPage(wd);
    productPage = new ProductPage(wd);
    busketPage = new BusketPage(wd);
  }

  public void quit() {
    wd.quit();
  }

  public void goToMainPage() {
    mainPage.open();
  }

  public void addProductsToBusket(){
    for (int i = 1; i < 4; i++) {
      mainPage.openProduct();
      productPage.selectSizeIfNeed();
      productPage.addProductToBusket();
      wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("a.content>span.quantity")), String.valueOf(i)));
      mainPage.open();
    }
  }

  public void openBusket() {
    mainPage.openBusket();
  }

  public void deleteProductsFromBusket() {
    for (int j = 1; j < 3; j++) {
      List<WebElement> itemsbefore = wd.findElements(By.cssSelector("td[style='text-align: center;']"));
      int numberItemsBefore = itemsbefore.size();
      wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item")));
      busketPage.removeProductFromBusket();
      wait.until(ExpectedConditions.stalenessOf(wd.findElement(By.cssSelector("td[style='text-align: center;']"))));
      List<WebElement> itemsafter = wd.findElements(By.cssSelector("td[style='text-align: center;']"));
      int numberItemsAfter = itemsafter.size();
      Assert.assertEquals(numberItemsAfter, numberItemsBefore - 1);
    }
  }

  public void checkEmptyBusket() {
    busketPage.checkEmptyBusket();
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
