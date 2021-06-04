package SeleniumConcepts.SeleniumConcepts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableSteps {

	WebDriver driver;
	Actions action;

	public void initBrowser(String browser) {

		if ("Chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", "/Users/goutambalasubramanian/Downloads/chromedriver");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("window-size=1400,800");
			option.addArguments("headless");
			driver = new ChromeDriver(option);

		}

		else if ("firefox".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.gecko.driver", "/Users/goutambalasubramanian/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}

		else if ("safari".equalsIgnoreCase(browser)) {
			driver = new SafariDriver();
		}

	}

	public void initProperty(String path) {

		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void geturl(String url) {

		driver.get(url);
		

	}

	public void appendUrl(String AppendUrlValue) {

		driver.get(driver.getCurrentUrl() + AppendUrlValue);

	}

	public void click(WebElement element) {

		element.click();

	}

	public void doubleClick(WebElement element) {

		action = new Actions(driver);

		action.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {

		action = new Actions(driver);

		action.contextClick(element).perform();
	}

	public void jsClick(WebElement element) {

		try {
			if (element.isDisplayed() && (element.isEnabled())) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			}
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace()); // TODO: handle exception
		}

	}
	
	public void enterJS(WebElement s) {
		((JavascriptExecutor) driver).executeScript("argument[0].value='value';",s);

	}

	public void refresh() {

		((JavascriptExecutor) driver).executeScript("history.go(0);");
		

	}

	public void scroll(String scrollHeight) {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + scrollHeight + ");");

	}

	public void scrollEnd() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}

	public void newTabOpen() {

		((JavascriptExecutor) driver).executeScript("window.open();");

	}
	
	

	public void switchToCurrentTab() {

		Set<String> tabs = driver.getWindowHandles();

		for (String a : tabs) {

			driver.switchTo().window(a);

		}

	}

	public void switchToSpecificTab(String name) {

		driver.switchTo().window(name);

	}

	public void switchToFrame(String name) {

		driver.switchTo().frame(name);
	}

	public void switchToFrameByIndex(int index) {

		driver.switchTo().frame(index);
	}

	public void implicitWait(int value) {

		driver.manage().timeouts().implicitlyWait(value, TimeUnit.MILLISECONDS);

	}

	public void waitUntillElementPresent(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public WebElement returnXpathWebEement(String value) {

		WebElement element = driver.findElement(By.xpath(value));

		return element;

	}

	public WebElement returnCSSSelectorWebEement(String value) {

		WebElement element = driver.findElement(By.cssSelector(value));

		return element;

	}

	public WebElement returnIDWebEement(String value) {

		WebElement element = driver.findElement(By.id(value));

		return element;

	}

	public void enterTextBox(String value, String element) {

		driver.findElement(By.xpath(element)).sendKeys(value);

	}

	public void enterTextBoxAndEnter(String value, String element) {

		driver.findElement(By.xpath(element)).sendKeys(value + Keys.ENTER);

	}

	public void clearAndEnterTextBox(String value, String element) {

		driver.findElement(By.xpath(element)).clear();
		driver.findElement(By.xpath(element)).sendKeys(value);

	}

	public void clearTextBox(WebElement element) {

		element.clear();

	}

	public void clickElement(WebElement element) {

		element.click();

	}

	public void submitButton(WebElement element) {

		element.submit();

	}

	public void hoverTheElement(WebElement element) {

		action.moveToElement(element).perform();

	}

	public void VerifyTooltipText(WebElement element, WebElement tooltipText, String text) {

		action.moveToElement(element).perform();

		assertTrue(text.equalsIgnoreCase(tooltipText.getAttribute("title")));

	}

	public void pointToAElementByRobot(WebElement element) {

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		org.openqa.selenium.Point point;
		point = element.getLocation();

		int x = point.getX();
		int y = point.getY();

		robot.mouseMove(x, y);

	}

	public void selectFromDropdownFromVisibletext(WebElement element, String text) {

		Select option = new Select(element);

		option.selectByVisibleText(text);

	}

	public void selectFromDropdownFromValue(WebElement element, String text) {

		Select option = new Select(element);

		option.selectByValue(text);

	}

	public void selectFromDropdownFromIndex(WebElement element, int index) {

		Select option = new Select(element);

		option.selectByIndex(index);

	}
	
	public void deSelectFromDropdownFromVisibletext(WebElement element, String text) {

		Select option = new Select(element);

		option.deselectByVisibleText(text);

	}

	public void deSelectFromDropdownFromValue(WebElement element, String text) {

		Select option = new Select(element);

		option.deselectByValue(text);

	}

	public void deSelectFromDropdownFromIndex(WebElement element, int index) {

		Select option = new Select(element);

		option.deselectByIndex(index);

	}
	
	public void dragAndDrop(WebElement src,WebElement des) {
		
		action.dragAndDrop(src, des);
		
		
	}
	
	public void typeInCapital(String text,WebElement element) {
		
		action = new Actions(driver);
		
		Action seriesOfAction = action
				.keyDown(element, Keys.SHIFT)
				.sendKeys(element, text)
				.keyUp(element, Keys.SHIFT)
				.build();
		
		seriesOfAction.perform();			
	}

	public void screenshot(String path) {

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcfile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
