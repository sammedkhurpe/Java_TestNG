import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class TestNG_Example_6 
{
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	
//	Different Annotations in TestNG to control the flow of execution.
	
//	@BeforeSuite >> executes only once before all tests in Suite run
	@BeforeSuite
	public void beforesuite()
	{
		Reporter.log("This is before suite", true);
	}
	
//	@BeforeClass >> executes only once before first test in Class runs 
	@BeforeClass
	public void beforeclass()
	{
		Reporter.log("This is before class", true);
	}
	
	
//	@BeforeMethod >> executes before each test
	@BeforeMethod
	public void startup()
	{
		Reporter.log("This is before method", true);
		playwright=Playwright.create();
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		page=context.newPage();
	}
	
//	@Test >> executes after @BeforeMethod
	@Test (priority=1)
	public void insta()
	{
		Reporter.log("Testcase: Login of Instagram", true);
		page.navigate("https://www.instagram.com/accounts/login/");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile number, username or email")).fill("8880808335");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("BlueDiamond@145");
		page.getByLabel("Log in").click();
	}
	
//	@Test >> executes after @BeforeMethod
	@Test (priority=2)
	public void facebook()
	{
		Reporter.log("Testcase: Login of Facebook", true);
		page.navigate("https://www.facebook.com/");
		page.getByLabel("Email address or mobile number").fill("8880808335");
		page.getByLabel("Password").fill("BlueDiamond@145");
		page.getByLabel("Log in").click();
	}
	
//	@AfterMethod >> executes after each test
	@AfterMethod
	public void closout()
	{
		Reporter.log("This is after method", true);
		page.close();
		browser.close();
		playwright.close();
	}
	
//	@AfterClass >> executes only once after all methods runs in a Class
	@AfterClass
	public void afterclass()
	{
		Reporter.log("This is after class", true);
	}
	
//	@AfterSuite >> execute only once after all tests run in a Suite
	@AfterSuite
	public void aftersuite()
	{
		Reporter.log("This is after suite", true);
	}
}
