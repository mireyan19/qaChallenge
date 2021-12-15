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

public class Register extends BaseRegister {



	@Test
	public void Registrar_UsuarioValido() {

		String ResultadoEsperado="SAVED";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("++++++");
		driver.findElement(Btn_register).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void Registrar_CorreoInvalido() {

		String ResultadoEsperado="SAVE";

		driver.findElement(Email).sendKeys("mirelahotmail.com");
		driver.findElement(Pass).sendKeys("+++++");
		driver.findElement(Btn_register).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void Registrar_PasswordIncompleto() {

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("++");
		driver.findElement(Btn_register).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void Registrar_SinPass() {

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("");
		driver.findElement(Btn_register).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void Registrar_Vacio() {

		String ResultadoEsperado="REQUIRED";

		driver.findElement(Email).sendKeys("");
		driver.findElement(Pass).sendKeys("");
		driver.findElement(Btn_register).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}


}
