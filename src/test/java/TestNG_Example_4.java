import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class TestNG_Example_4
{
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	
	
	@BeforeMethod
	public void setup()
	{
		playwright=Playwright.create();
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page=context.newPage();
	}
	
	
//	Running multiple test cases
//	Number of time a test case execution
//	default invocation count 1
	
	@Test (priority=1, invocationCount=2)
	public void insta()
	{
		Reporter.log("Login of Instagram", true);
		page.navigate("https://www.instagram.com/accounts/login/");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number, username or email")).fill("8880808335");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("BlueDiamond@145");
		page.getByLabel("Log in").click();
	}
	
	@Test (invocationCount=3, priority=2)
	public void facebook()
	{
		Reporter.log("Login of Facebook", true);
		page.navigate("https://www.facebook.com/");
		page.getByLabel("Email address or mobile number").fill("8880808335");
		page.getByLabel("Password").fill("BlueDiamond@145");
		page.getByLabel("Log in").click();
	}
	
	@AfterMethod
	public void closeout()
	{
		page.close();
		browser.close();
		playwright.close();
	}
}
