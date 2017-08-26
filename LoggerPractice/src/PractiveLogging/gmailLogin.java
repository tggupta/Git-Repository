package PractiveLogging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import locators.AddLocators;
import locators.StarredURLLocators;

public class gmailLogin {

	WebDriver driver=null;
	
	@Test
	public void Login() throws IOException, InterruptedException
	{
		
	File file = new File("C:\\Users\\Tarun\\workspace\\LoggerPractice\\src\\PractiveLogging\\FileProperties.properties");
	FileInputStream fis=new FileInputStream(file);
	
	Properties prop=new Properties();
	prop.load(fis);
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Tarun\\workspace\\LoggerPractice\\lib2\\chromedriver_new.exe");
	driver=new ChromeDriver();
	//driver.get("http://gmail.com");
	
	PageFactory.initElements(driver, AddLocators.class);
	AddLocators obj=new AddLocators(driver);
	
	
	driver.get(prop.getProperty("URL"));
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(prop.getProperty("username"));
	obj.EnterUsername("tggupta1");
		System.out.println("tggupta1 entered");
	
	driver.findElement(By.xpath("//*[@id='identifierNext']/content")).click();
		System.out.println("next button is clicked");
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
	Thread.sleep(5000);
		System.out.println("password screen is visible");
	//driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(prop.getProperty("password"));
	obj.EnterPassword("122jammu");
		System.out.println("password is entered");
	driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		System.out.println("next button is clicked");
	Thread.sleep(5000);
	//driver.findElement(By.).click();
	driver.findElement(By.xpath("//*[@id=':4o']/div/div[2]")).click();
	
	System.out.println("Starred link is clicked");
	Thread.sleep(5000);
	StarredURLLocators obj1=new StarredURLLocators(driver);
	obj1.More();
	System.out.println("more drodown is clicked");
	
	Thread.sleep(2000);
	obj1.MarkAllasRead();
	
	Thread.sleep(2000);
	obj1.SelectAll();
	
	Thread.sleep(2000);
	obj1.MarkAllasUnRead();
	
	}
}