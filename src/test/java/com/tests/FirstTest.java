package com.tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class FirstTest {
	
  WebDriver driver;
  @Test
  public void f() {
	  WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
      email.sendKeys("archanataneja@gmail.com");
      String s = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div/div")).getText();
      System.out.println(" value is : "+s);
      
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--test-type");
	  options.addArguments("window-size=1400,600");
      options.addArguments("headless");
      options.addArguments("--disable-extensions");
      
      ChromeDriverService driverService = ChromeDriverService.createDefaultService();
      
      driver=new ChromeDriver(driverService, options);
      driver.get("http://www.facebook.com");
      //driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
      
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
