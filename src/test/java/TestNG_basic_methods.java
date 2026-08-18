import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestNG_basic_methods 
{
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	
	
//	@BeforeMethod runs before each @Test method
	@BeforeMethod
	public void setup()
	{
		
	}
	
	
//	@Test runs after @BeforeMethod & before @AfterMethod
	@Test
	public void test1()
	{
//		To print the message only in Console
		System.out.println("Only in Console: "+"Hello TestNG");
		
//		To print the message in both Console & TestNG report
		Reporter.log("In both Console & TestNG report: "+"Hello TestNG", true);
		
//		To print the message only in TestNG report
		Reporter.log("Only in TestNG report: "+"Hello TestNG", false);
		
//		To print the message 
	}
	
	
//	@AfterMethod runs after each @Test method
	@AfterMethod
	public void closeout()
	{
		
	}
	
}
