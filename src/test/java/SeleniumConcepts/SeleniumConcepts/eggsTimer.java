package SeleniumConcepts.SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class eggsTimer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new SafariDriver();
		
		driver.get("https://e.ggtimer.com/60");
		
//		driver.findElement(By.xpath("//input[@class='EggTimer-start-time-input-text']")).click();
//		
//		driver.findElement(By.xpath("//input[@class='EggTimer-start-time-input-text']")).sendKeys("60");
//		
//		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		StringBuffer s = new StringBuffer();
		
		String q = "";
		
		for(int i=0;i<60;i++) {
			
			if(!q.equals(driver.findElement(By.xpath("//p[@class='ClassicTimer-time']//span")).getText())) {
			q = (driver.findElement(By.xpath("//p[@class='ClassicTimer-time']//span")).getText());
			
			System.out.println(q);
			}
			
		}
		
		

	}

}
