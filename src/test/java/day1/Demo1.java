package day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {
	@Parameters({"gridURL","appURL"})
	@Test
	public void testa(String gridURL, String appURL) throws InterruptedException, MalformedURLException {
		Reporter.log("Testamethod",true);
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		driver.get(appURL);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("9740971888");
		driver.findElement(By.id("pass")).sendKeys("santhosh8");
		driver.findElement(By.name("login")).click();
		Thread.sleep(7000);
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
