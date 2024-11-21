package Seleinum_WebDriver.Automation_framework_monofia;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
 
public class LoginTest_HappyScenario {
  WebDriver driver;
  @BeforeTest
  public void openBrowser() {
	  driver = new ChromeDriver();
	  driver.navigate().to("https://the-internet.herokuapp.com/login");
  }

 
  public void loginElements(String username,String password) {
	  WebElement usernameTxt = driver.findElement(By.id("username"));
	  WebElement passwordTxt = driver.findElement(By.name("password"));
	  WebElement loginBtn = driver.findElement(By.className("radius"));
	  usernameTxt.clear();
	  passwordTxt.clear();
	  usernameTxt.sendKeys(username);
	  passwordTxt.sendKeys(password);
	  loginBtn.click();
  }
  @Test(priority = 1)
  public void testLogin_CorrectUsernameAndPassword() throws InterruptedException {
	  loginElements("tomsmith","SuperSecretPassword!");
	  Thread.sleep(3000);
	  WebElement successMessage = driver.findElement(By.id("flash"));
	  Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"));
  }


  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }
 
}