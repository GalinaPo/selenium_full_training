package ru.stqa.training.selenium.tests;

import org.junit.Test;


public class BasketTest extends TestBase {

  @Test
  public void basketTest() {
    app.goToMainPage();
    app.addProductsToBusket();
    app.openBusket();
    app.deleteProductsFromBusket();
    app.checkEmptyBusket();
  }
}
