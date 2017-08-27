package PractiveLogging;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(PractiveLogging.Listener.class)
public class fluentwait extends WindowHandling {
	
	@Test
	public void openBrowser() throws IOException, InterruptedException
	{
//	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver= null;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tarun\\workspace\\LoggerPractice\\lib2\\chromedriver_new.exe");	
		driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");

		WindowHandling wd=new WindowHandling();
		wd.switchWindow(1, driver);
		driver.close();

		wd.switchWindow(0, driver);
		//explicit wait
		/*	WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable
			(By.xpath("//*[@id='tabJ-1']/ul[3]/li[4]/ul/li[2]/a"))).click();*/

		//fluent wait
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.pollingEvery(30, TimeUnit.SECONDS)
				.withTimeout(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//*[@id='tabJ-1']/ul[3]/li[4]/ul/li[2]/a"))).click(); 
		//driver.findElement(By.xpath("/*[@id='tabJ-1']/ul[3]/li[4]/ul/li[2]/a")).click();;
		Thread.sleep(5000);

		WindowHandling wd1=new WindowHandling();
		wd1.switchWindow(2,driver);
		Thread.sleep(5000);
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver)
				.pollingEvery(30, TimeUnit.SECONDS)
				.withTimeout(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		wait1.until(ExpectedConditions.presenceOfElementLocated
				(By.xpath("//*[@id='pageC']/div[3]/div[1]/div[2]/div[2]/p/a")));
		
		//driver.findElement(By.xpath("//*[@id='pageC']/div[3]/div[1]/div[2]/div[2]/p/a"));
		System.out.println("View All link is visible");
		String expectedpagetitle="SunLife India – Jobs in SunLife India - Career in SunLife India – Job Openings in SunLife India";
		String title=driver.getTitle();
		System.out.println(title);
		try{
			System.out.println("Checking Assertions");
			Assert.assertEquals(title, expectedpagetitle);
			System.out.println("Assertion passed");
			System.out.println("Taking Screenshot initiated");
			
			Screenshot sc = new Screenshot();
			sc.takeScreenshot(driver);
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion Failed "+e.getMessage());
		}
			
	}
}
