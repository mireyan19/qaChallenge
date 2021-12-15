package com.automation.testng;

import org.testng.annotations.Test;
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
import org.testng.annotations.BeforeTest;

public class Login extends BaseLogIn{

	@Test
	public void LogIn_UsuarioValido() {
		
		//El ingreso debe ser exitoso
		String ResultadoEsperado="LOGIN VALID";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("++++++");
		driver.findElement(Btn_login).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void LogIn_CorreoInvalido() {
		//El resultado debe ser inválido porque el correo no contiene '@'

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("mirelahotmail.com");
		driver.findElement(Pass).sendKeys("+++++");
		driver.findElement(Btn_login).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void LogIn_PasswordIncompleto() {
		//El resultado debe ser inválido porque el password no cumple con el requerimiento

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("++");
		driver.findElement(Btn_login).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void LogIn_SinPass() {
		//El resultado debe ser inválido porque el password está en blanco

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("mirela@hotmail.com");
		driver.findElement(Pass).sendKeys("");
		driver.findElement(Btn_login).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

	@Test
	public void LogIn_Vacio() {
		//El resultado debe ser inválido porque el correo y contraseña están vacíos	

		String ResultadoEsperado="INVALID";

		driver.findElement(Email).sendKeys("");
		driver.findElement(Pass).sendKeys("");
		driver.findElement(Btn_login).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Boolean verifyMessage = driver.findElement(Msg).getText().equals(ResultadoEsperado);
		assertTrue(verifyMessage);

	}

}
