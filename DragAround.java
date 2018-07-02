 package TatocUsingJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DragAround 
{
	WebDriver driver;
	JavascriptExecutor js;
public DragAround(JavascriptExecutor js,WebDriver driver)
{
	this.js=js;
	this.driver=driver;
}

public void isDragPage()
{
Assert.assertEquals(js.executeScript("return window.location.href"),"http://10.0.1.86/tatoc/basic/drag");	
}

public PopUpWindows Draganddrop()
{
	js.executeScript("document.getElementById(\"dragbox\").setAttribute('style','position:relative; left:32px; top:-76px;');");
	js.executeScript("document.querySelector(\".page > a:nth-child(10)\").click();");
    Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Popup Windows");
    return new PopUpWindows(js,driver);

}

}
