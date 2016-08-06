package com.nokia.a360automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 
 * Use latest updated selenium version (2.53.1) for using it with latest firefox version (47.0.1)
 */
public class App 
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{

		if(args.length > 0 )
		{
			System.out.println("Your Arguments are not considered in prog. execution");
		}

		Constants constants = Constants.getConstants();

		FirefoxProfile firefoxProfile = new FirefoxProfile();

		firefoxProfile.setPreference("browser.download.folderList",2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		firefoxProfile.setPreference("browser.download.dir",constants.getDownloadPath());
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");

		WebDriver driver = new FirefoxDriver(firefoxProfile);
		WebDriverWait wait = new WebDriverWait(driver, constants.getWebDriverTimeout());

		driver.get(constants.getSiteUrl());

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("samlButton"))));
		WebElement signOnButton = driver.findElement(By.id("samlButton"));
		signOnButton.click();


		Thread.sleep(constants.getSleepTime());


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUser")));
		WebElement signInButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table[1]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/form/table/tbody/tr[3]/td[2]/input[4]"));
		WebElement userText = driver.findElement(By.id("txtUser"));
		WebElement userPass = driver.findElement(By.id("txtPassword"));

		userText.sendKeys(constants.getUsername());
		userPass.sendKeys(constants.getPassword());
		signInButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen77")));
		WebElement dashboardButton = driver.findElement(By.id("ext-gen77"));
		dashboardButton.click();

		Thread.sleep(2000);
		Robot robot = new Robot();
		keyPressRelease(robot, KeyEvent.VK_ENTER);
		
		Thread.sleep(17000);
		
		customMousePressReleaseAtPointXY(robot, 1224, 100);
		Thread.sleep(10000);
		customMousePressReleaseTASK(robot, 23, 229);
		Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 140, 39);//Action Menu 140,39
		Thread.sleep(8000);
		customMousePressReleaseAtPointXY(robot, 226, 416);//import task Button 226,416
		//Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 709, 401);//Task Type drop down 709,401
		//Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 652, 452);//FE E2E Testing Task 652,452
		//Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 416, 429);	//Text Area click 416,429
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		keyPressRelease(robot, KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//Thread.sleep(1000);
		customMousePressReleaseAtPointXY(robot, 939, 591);//External ID behaviour dropdown 939,591
		//Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 872, 634);//External ID behaviour dropdown selection 872,634
		//Thread.sleep(5000);
		customMousePressReleaseAtPointXY(robot, 1110, 703); //Import button 1110,703
		Thread.sleep(10000);
		customMousePressReleaseAtPointXY(robot, 1028, 544); //OK button 1028, 544
	}
	
	public static void customMousePressReleaseAtPointXY(Robot robot,int x, int y) throws InterruptedException
	{
		//a360 maximize 1224,100
		//a360 task button 23,229
		//Action Menu 140,39
		//import task Button 226,416
		//Task Type drop down 709,401
		//FE E2E Testing Task 652,452
		//Text Area click 416,429
		//Ctrl + v
		//External ID behaviour dropdown 939,591
		//External ID behaviour dropdown selection 872,634
		//Import button 1110,703
		
		
		 robot.mouseMove(x, y);
		 Thread.sleep(3000);
		 robot.mousePress(InputEvent.BUTTON1_MASK);
		 robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void customMousePressReleaseTASK(Robot robot,int x, int y) throws InterruptedException
	{
		 robot.mouseMove(x, y);
		 Thread.sleep(6000);
		 robot.mousePress(InputEvent.BUTTON1_MASK);
		 //Thread.sleep(6000);
		 robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void keyPressRelease(Robot robot, int code){
		robot.keyPress(code);
		robot.keyRelease(code);
	}

}
