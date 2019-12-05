package com.tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
      
      driver=new ChromeDriver();
      driver.get("http://www.facebook.com");
      driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
