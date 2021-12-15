package com.automation.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseLogIn {

	WebDriver driver;

	By TitleRegister = By.xpath("/html/body/h1");
	By Email = By.id("email");
	By Pass = By.id("password");
	By Btn_login = By.id("login");
	By Msg = By.id("msg");

	@BeforeMethod
	public void LoginConnection() {
		System.setProperty("webdriver.edge.driver", "C:/Users/yilai/Documents/qaChallenge/RetoUTP/drivers/msedgedriver.exe") ;
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4000/login");

	}

	@AfterMethod
	public void Cierre() {
		driver.quit();
	}

}
