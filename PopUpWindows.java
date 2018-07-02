package TatocUsingJS;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PopUpWindows {
	WebDriver driver;
	JavascriptExecutor js;
public PopUpWindows(JavascriptExecutor js,WebDriver driver)
{
	this.js=js;
	this.driver=driver;
}

public void ispopuppage()
{
	Assert.assertEquals(js.executeScript("return window.location.href"),"http://10.0.1.86/tatoc/basic/windows");
}
public CookieHandling launch()
{
	js.executeScript("document.querySelector(\" .page>a:nth-child(4)\").click()");
	String parentwindow=driver.getWindowHandle();
	String subwindow=null;
	Set<String> handle=driver.getWindowHandles();
	Iterator itr=handle.iterator();
	while(itr.hasNext())
	{
		subwindow=(String) itr.next();
	}
	driver.switchTo().window(subwindow);
    js.executeScript("document.getElementById('name').value='abc'");
    js.executeScript("document.getElementById('submit').click()");
    driver.switchTo().window(parentwindow);
    js.executeScript("document.querySelector(\" .page>a:nth-child(6)\").click()");
    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Cookie Handling");
    return new CookieHandling(js,driver);
}
}
