package com.selenium;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Test3 {

	private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  
/*	System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer.64.exe");  
	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    driver = new InternetExplorerDriver(ieCapabilities);*/
	  
/*	System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
	System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\geckodriver.exe"); 
    driver = new FirefoxDriver();    */

	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
    System.setProperty("webdriver.chrome.bin", "C:\\Users\\dujuan\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
  	driver = new ChromeDriver();
    
    baseUrl = "http://192.168.1.62:1952/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl);
    driver.manage().window().maximize();
    Thread.sleep(5000);
    //JOptionPane.showMessageDialog(null,"0");
       
    //driver.findElement(By.xpath("//input[id()='txtUser']"));
    
    
    driver.findElement(By.id("txtUser")).sendKeys("377");
    driver.findElement(By.id("txtPWD")).sendKeys("111111");
    driver.findElement(By.id("txtValied")).click();
    driver.findElement(By.id("ibtnLogin")).click();
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | left | ]]
    driver.switchTo().frame("left").findElement(By.id("t1")).click();
    driver.findElement(By.linkText("PNR内容生成订单")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=right | ]]
    driver.switchTo().defaultContent();
    driver.switchTo().frame("right");
    driver.findElement(By.id("txtContent")).sendKeys("1.刘西北 HTMHLV\n2. HO1322 M SU13NOV KWLSHA HK1 1240 1535 E --T2\n3.PEK/T PEK/T99887766/HUOXINQIULAIDE SOUTHWEST TRAVEL/HUO XIN QIU ABCDEFG 4.13800138000/P1\n5.TL/1200/13NOV/BJS111\n6.SSR FOID\n7.SSR ADTK 1E BY YYY11NOV11/1240 OR CXL HO1322 M13NOV\n8.OSI HO CTCT13800138000/P1\n9.RMK CA/HYGNKR\n10.BJS111\n>\n>PAT:A\nPAT:A\n01 M FARE:CNY1520.00 TAX:CNY50.00 YQ:CNY130.00 TOTAL:1700.00\n>SFC:01\n>");
    
    driver.findElement(By.id("bntlrCreateOrder2")).click();
    //waiting for chaeak passengers's info
    
    
    
  }

/*  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }*/

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}
