package ru.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationUser extends TestBase {

  @Test
  public void registrationUser(){
    wd.get("http://localhost/litecart/");
    wd.findElement(By.linkText("Create Account")).click();
    long now = System.currentTimeMillis();
    String email = String.format("user%s@mail.com", now);
    wd.findElement(By.name("firstname")).sendKeys("ga");
    wd.findElement(By.name("lastname")).sendKeys("ga");
    wd.findElement(By.name("address1")).sendKeys("address1");
    wd.findElement(By.name("postcode")).sendKeys("12345");
    wd.findElement(By.name("city")).sendKeys("city");
    wd.findElement(By.className("select2-selection__rendered")).click();
    wd.findElement(By.className("select2-search__field")).sendKeys("United States" + Keys.ENTER);
    wd.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
    wd.findElement(By.cssSelector("input[name='phone']")).sendKeys("+16788888888");
    wd.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
    wd.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys("password");
    wd.findElement(By.cssSelector("button[value='Create Account']")).click();
    wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.linkText("Logout"))));
    wd.findElement(By.linkText("Logout")).click();
    wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.linkText("Login"))));
    wd.findElement(By.name("email")).sendKeys(email);
    wd.findElement(By.name("password")).sendKeys("password");
    wd.findElement(By.cssSelector("button[value='Login']")).click();
    wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.linkText("Logout"))));
  }
}
