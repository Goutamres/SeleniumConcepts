package SeleniumConcepts.SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class toolsQASelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "/Users/goutambalasubramanian/Downloads/chromedriver2");
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		
		driver.get("https://demoqa.com/checkbox");
		
//		driver.get("https://e.ggtimer.com/");
		
//		driver.findElement(By.id("#EggTimer-start-time-input-text")).click();
//		
//		driver.findElement(By.id("#EggTimer-start-time-input-text")).sendKeys("10");
//		
//		driver.findElement(By.xpath("//button[text()='Start']")).click();
		driver.manage().window().maximize();
	
		
		String path = "Home->Desktop->Commands";
		
		
		String path1[] = path.split("->");
		
		for(int i=0;i<path1.length;i++) {
			
		if(i==path1.length-1) {
			driver.findElement(By.xpath("//span[text()='"+ path1[i] +"']//ancestor::label//span[@class='rct-checkbox']")).click();
		}
		
		else {
			driver.findElement(By.xpath("//span[text()='"+ path1[i] +"']//ancestor::span//button[@title='Toggle']")).click();
		}
				
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
