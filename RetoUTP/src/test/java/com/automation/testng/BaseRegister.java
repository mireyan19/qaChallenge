package com.automation.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BaseRegister {
	WebDriver driver;

	By TitleRegister = By.xpath("/html/body/h1");
	By Email = By.id("email");
	By Pass = By.id("password");
	By Btn_register = By.id("register");
	By Msg = By.id("msg");

	@BeforeMethod
	public void RegisterConnection() {
		System.setProperty("webdriver.edge.driver", "C:/Users/yilai/Documents/qaChallenge/RetoUTP/drivers/msedgedriver.exe") ;
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4000/register");

	}

	@AfterMethod
	public void Cierre() {
		driver.quit();
	}
}
