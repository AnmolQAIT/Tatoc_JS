package TatocUsingJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TatocTest {
   WebDriver driver;
   JavascriptExecutor js;
   Basic basic;	
   GridGate grid;
   FrameDungeon frame;
   DragAround drag;
   PopUpWindows popup;
   CookieHandling cookiehandle;
	@BeforeClass
	public void invokeBrowser()
	{
		driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		js=(JavascriptExecutor)driver;
		basic=new Basic(js,driver);
	}
	
	@Test(priority=1)
	public void basicpagecheck()
	{
		basic.isBasicpage();
		grid=basic.isclickonBasicworking();
	}
	
	@Test(priority=2)
	public void Grid()
	{
		grid.isgridpage();frame=grid.clickongreenbox();
	}
	
	@Test(priority=3)
	public void framedungeon()
	{
		frame.isFrameDungeonPage();drag=frame.matchthecolorofboxes();
	}
	
	@Test(priority=4)
	public void drag()
	{
		drag.isDragPage();popup=drag.Draganddrop();
	}
	
	@Test(priority=5)
	public void popupwindows()
	{
		popup.ispopuppage();cookiehandle=popup.launch();
	}
	
	@Test(priority=6)
	public void cookie()
	{
		cookiehandle.iscookiepage();cookiehandle.AddCookie();
	}
}
