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

public class TestNG_Example_1
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
	
	@Test
	public void insta() 
	{
		Reporter.log("Login of Instagram", true);
		page.navigate("https://www.instagram.com/accounts/login/");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number, username or email")).fill("8880808335");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("BlueDiamond@145");
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
