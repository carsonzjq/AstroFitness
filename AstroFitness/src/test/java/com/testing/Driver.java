package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	static WebDriver driver;
	static String url = "http://newtours.demoaut.com";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		//Stats the driver and opens it at the specified url.
		driver.get(url);
		Thread.sleep(5000);
		driver.quit();
	}
}
