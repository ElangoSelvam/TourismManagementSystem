package com.tms.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
   //maximize the window
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	//Wait conditions
	public void waits(WebDriver driver,int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public void getElementUntilFind(WebDriver driver,int duration,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//select class is used to handle the  dropDown
	public void select(WebElement element,int index) {
		Select s=new Select(element); 
		s.selectByIndex(index);	
		
	}
	public void select(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);		
	}
	public void select(String text,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	//Action class is used to handle the mouse hover actions and keyboard actions
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();	
	}
	public void dragAnddrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions action = new Actions(driver); 
			action.dragAndDrop(src,dest).perform();
	}
	public void rightclick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();			
	}
	public void rightclick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();			
	}
	public void doubleClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}
	public void enterKeyPress(WebDriver driver) {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	//Robot class is used to handle the Keyboard operations
	public void enterKey() throws Throwable {
		Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
	}
	public void keyRelease(WebDriver driver) throws Throwable {
		Robot robot=new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	//Frame is used to handle the webPage
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}
	// Alert is used to handle the popup
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	//WindowHandle is used to handle the browser
	public String switchToWindow(WebDriver driver,String title) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		while(itr.hasNext()) {
			String winId=itr.next();
			String currentWinTitle=driver.switchTo().window(winId).getTitle();
			if(currentWinTitle.equalsIgnoreCase(title)) {
				break;
			}
			
		}
		return title;
	}
	// JavaScript is used to handle the x and y axis and scrolling options
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)","");
	}
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(800,0)","");
	}
	
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+"))",element);
		//js.executeScript("argument[0].scrollIntoView()",element);
		
	}
	
	
}
