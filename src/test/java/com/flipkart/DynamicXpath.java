package com.flipkart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicXpath {
	@Test
	public void addTocompareAction() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles",Keys.ENTER);
		String prodName="POCO C71 (Power Black, 128 GB)";
		driver.findElement(By.xpath("//div[text()='"+prodName+"']/ancestor::a[@class='CGtC98']/descendant::span[text()='Add to Compare']")).click();
	}

}
