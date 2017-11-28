package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class SortCountriesGeoZones extends TestBase {

  @Before
  public void loginAdminLitecart() {
    wd.get("http://localhost/litecart/admin/");
    wd.findElement(By.name("username")).click();
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
  }


  @Test
  public void sortCountriesZones() {
    wd.findElement(By.linkText("Countries")).click();
    List<WebElement> elements = wd.findElements(By.className("row"));
    for (int i = 1; i < elements.size(); i++) {
      List<WebElement> el = wd.findElements(By.className("row"));
      String elcurrent = "";
      String elprev = "";
      elcurrent = el.get(i).findElement(By.tagName("a")).getAttribute("textContent");
      elprev = el.get(i - 1).findElement(By.tagName("a")).getAttribute("textContent");
      assertTrue(elcurrent.compareTo(elprev) > 0);
    }
    List<WebElement> elem = wd.findElements(By.className("row"));
    for (int k = 0; k < elem.size(); k++) {
      List<WebElement> ele = wd.findElements(By.className("row"));
      String countzone = "";
      countzone = ele.get(k).findElement(By.xpath(".//td[6]")).getAttribute("textContent");
      if (!Objects.equals(countzone, "0")) {
        List<WebElement> el1 = wd.findElements(By.className("row"));
        el1.get(k).findElement(By.tagName("a")).click();
        List<WebElement> zones = wd.findElements(By.cssSelector("#table-zones tr"));
        for (int j = 2; j < zones.size()-1; j++) {
          List<WebElement> zon =  wd.findElements(By.cssSelector("#table-zones tr"));
          String zoncurrent = "";
          String zonprev = "";
          zoncurrent = zon.get(j).findElement(By.xpath("td[3]")).getAttribute("textContent");
          zonprev = zon.get(j-1).findElement(By.xpath("td[3]")).getAttribute("textContent");
          assertTrue(zoncurrent.compareTo(zonprev) > 0);
        }
        wd.findElement(By.linkText("Countries")).click();
      }
    }

    wd.findElement(By.linkText("Geo Zones")).click();
    List<WebElement> elements2 = wd.findElements(By.className("row"));
    for (int i = 0; i < elements2.size(); i++) {
      List<WebElement> el = wd.findElements(By.className("row"));
      el.get(i).findElement(By.tagName("a")).click();
      List<WebElement> zones = wd.findElements(By.cssSelector("#table-zones tr"));
      for (int j = 2; j < zones.size()-1; j++) {
        List<WebElement> zon =  wd.findElements(By.cssSelector("#table-zones tr"));
        String zoncurrent = "";
        String zonprev = "";
        zoncurrent = zon.get(j).findElement(By.xpath(".//td[3]/select/option[@selected='selected']"))
                .getAttribute("textContent");
        zonprev = zon.get(j-1).findElement(By.xpath(".//td[3]/select//option[@selected='selected']")).getAttribute("textContent");
        assertTrue(zoncurrent.compareTo(zonprev) > 0);
      }
      wd.findElement(By.linkText("Geo Zones")).click();
    }
  }
}
