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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo1 {
	@Parameters({"gridURL","appURL"})
	@Test
	public void testa(String gridURL, String appURL) throws InterruptedException, MalformedURLException {
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("report/SparkTest.html");
		report.attachReporter(spark);
		ExtentTest extest=report.createTest("To Login facebook");
		extest.info("Facebook logining");
		WebDriver driver=new RemoteWebDriver(new URL(gridURL),new ChromeOptions());
		driver.get(appURL);
		extest.info(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("9740971888");
		driver.findElement(By.id("pass")).sendKeys("santhosh8");
		driver.findElement(By.name("login")).click();
		Thread.sleep(7000);
		extest.info(driver.getTitle());
		driver.close();
		
	}

}
