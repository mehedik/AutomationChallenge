package com.stadiumgood.challenge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class SignInPageTest {
	
	@Test
	public void testSignin() throws Exception {
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mehed\\eclipse-workspace\\challenge\\drivers\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver();
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\mehed\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://stadium:goods2018!@stage.stadiumgoods.cloud");
	String username = "stadium";
	String password = "goods2018!";
	
	Robot robot = new Robot();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection stringSelection = new StringSelection(username);
    clipboard.setContents(stringSelection, null);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
    Thread.sleep(3000);
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
    
    Thread.sleep(1000);
    StringSelection stringSelection1 = new StringSelection(password);
    clipboard.setContents(stringSelection1, null);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
    Thread.sleep(3000);
    
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
	public void login() throws Exception {
	    // Pass username
	    autoType("stadium");
	    // to move to Password field
	    autoTab();
	    // Enter Password
	    autoType("goods2018!");
	    // To click on login
	    autoSubmit();
	}

	public static void autoType(String string) throws AWTException {
	    Robot robot = new Robot();
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    StringSelection stringSelection = new StringSelection(string);
	    clipboard.setContents(stringSelection, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void autoTab() throws AWTException {
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_TAB);
	}

	public static void autoSubmit() throws AWTException {
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	  private static void setClipboardData(String string) {
          // TODO Auto-generated method stub
                      StringSelection stringSelection = new StringSelection(string);                            
                      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
      }
}