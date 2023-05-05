package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Pages.LoginPage;

 public class LoginTest extends Baseclass {
//	@Test
 public void test1() {
	   LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("rajesh", "googlesadas");
	    WebElement Ne = driver.findElement(By.id("error_box"));
	    String error = Ne.getText();
	    String ANE = "Please enter a valid email address";
	 	Assert.assertEquals(error, ANE);

	}

	@Test
	public void test2() {
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("Kumar", "notgoodddd");
	}

	@Test
	public void test4(Method method) throws FilloException {
		Recordset recordset = connection.executeQuery("select * from data where TestName='Test4'");
		recordset.next();
		String UserName = recordset.getField("UserName");
		String Pasword = recordset.getField("Pasword");
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction(UserName, Pasword);
	}
}
