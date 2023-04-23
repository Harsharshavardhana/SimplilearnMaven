package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;
	//======objects=======//
	@FindBy(linkText="Log in")
	WebElement loginLink;
	@FindBy(name="user_login")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(className="rememberMe")
	WebElement RememberMe;
	@FindBy(name="btn_login")
	WebElement loginBtn;
	//==========methods==========//
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginFunction(String UserName, String Password) 
	{
		loginLink.click();
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		RememberMe.click();
		loginBtn.click();
	}
}
