package TatocUsingJS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Basic {
    JavascriptExecutor js;
    WebDriver driver;

    public Basic(JavascriptExecutor js,WebDriver driver)
    {
    	this.js=js;
    	this.driver=driver;
    }
    
    public void isBasicpage()
    {
    	Assert.assertEquals(js.executeScript("return window.location.href").toString(),"http://10.0.1.86/tatoc");        
    }
    public GridGate isclickonBasicworking()
    {
    	js.executeScript("document.querySelector(\"body>div>.page>a:nth-child(4)\").click()");
    	Assert.assertNotEquals(js.executeScript("return window.location.href").toString(),"http://10.0.1.86/tatoc");
    	return new GridGate(js,driver);
    }
    
    
}
