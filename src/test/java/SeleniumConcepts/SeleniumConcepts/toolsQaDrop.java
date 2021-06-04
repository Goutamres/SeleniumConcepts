package SeleniumConcepts.SeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class toolsQaDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new SafariDriver();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/select-menu");
		
		driver.findElement(By.xpath("//div[text()='Select Option']")).click();
		
		driver.findElement(By.xpath("//*[text()='Group 2, option 1']")).click();
		
		
	driver.findElement(By.xpath("//div[text()='Select Title']")).click();
	
	driver.findElement(By.xpath("//*[contains(text(),'Mr.')]")).click();
		
		
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Select Option']"))).click();
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Group 1, option 1')]"))).click();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(., 'Uttar Pradesh')]"))).click();
		
		

	}

}
