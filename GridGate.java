package TatocUsingJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GridGate {
 WebDriver driver;
 JavascriptExecutor js;
	
 public GridGate(JavascriptExecutor js,WebDriver driver)
	{
		this.js=js;this.driver=driver;
	}

public void isgridpage()
{
  Assert.assertEquals(js.executeScript("return window.location.href").toString(),"http://10.0.1.86/tatoc/basic/grid/gate");
}
 

public FrameDungeon clickongreenbox()
{
	 js.executeScript("document.getElementsByClassName(\"greenbox\")[0].click()");
	 Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent;"), "Frame Dungeon");
	 return new FrameDungeon(driver,js);
}


 
}
