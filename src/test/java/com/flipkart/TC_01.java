package com.flipkart;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_01 {
	@Test
	public void captureProductName() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kurti");
		driver.findElement(By.xpath("//img[@src='https://rukminim2.flixcart.com/image/100/100/xif0q/ethnic-set/4/i/6/xl-od-83-trahimam-original-imahgk6gfktyn4cq.jpeg?q=90']")).click();

		WebElement product = driver.findElement(By.xpath("(//img[@class='_53J4C-'])[position()=1]"));

		product.click();
		String parent = driver.getWindowHandle();
		
		Set<String> windowIds = driver.getWindowHandles();
		for(String id:windowIds) {
			
			driver.switchTo().window(id);
			
			String actUrl = driver.getCurrentUrl();
			
			if(actUrl.contains("https://www.flipkart.com/tibra-attire-women-kurti-")) {
				break;
			}
		}
		
		String prodName = driver.findElement(By.xpath("//span[text()='Women Cotton Blend Kurti Pant Dupatta Set']")).getText();
		
		System.out.println(prodName);
		WebElement prodDetailsMsg = driver.findElement(By.xpath("//div[@class='col col-11-12 rYpYQA']"));
		System.out.println(prodDetailsMsg.getText());
		prodDetailsMsg.click();
		
		Actions act=new Actions(driver);
		
		act.scrollToElement(prodDetailsMsg);
		
		WebElement prodDetails = driver.findElement(By.xpath("//div[@class='sBVJqn _8vsVX1']"));
		
		System.out.println(prodDetails.getText());
		
//		driver.switchTo().window(parent);
		
	}
		
	

}
