package TatocUsingJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CookieHandling {
	WebDriver driver;
	JavascriptExecutor js;
public CookieHandling(JavascriptExecutor js,WebDriver driver)
{
	this.js=js;
	this.driver=driver;
}

public void iscookiepage()
{
	Assert.assertEquals(js.executeScript("return window.location.href"),"http://10.0.1.86/tatoc/basic/cookie");	
}

public void AddCookie() {
	String token=generateToken();
	token = token.substring(token.indexOf(":")+2);
	String JScommand="document.cookie = 'Token="+token+"';";
	js.executeScript(JScommand);
	js.executeScript("document.querySelector('.page > a:nth-child(10)').click()");
    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "End");

}

private String generateToken() {
    js.executeScript("document.querySelector('body > div > div.page > a:nth-child(8)').click();");	
    return (String)js.executeScript("return document.getElementById('token').innerHTML");
}
}
