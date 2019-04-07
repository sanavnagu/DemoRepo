
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class Highlight {
 
@Test
 public void highlightElement() {
	
SoftAssert s_assert = new SoftAssert();
 System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
        //Instantiating driver object
 WebDriver driver = new ChromeDriver();
        //To launch gmail.com
 driver.get("https://www.hdfcbank.com");
 
 //WebElement e = driver.findElement(By.xpath("//*[@id=\"div-close\"]"));
 
// e.click();
 
        //Collects the webelement
 WebElement ele = driver.findElement(By.xpath("//*[@id=\"loginsubmit\"]"));
        //Create object of a JavascriptExecutor interface
 JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
 
 ele.click();
 
 String Parentwindow = driver.getWindowHandle();
 
 for(String childwindow:driver.getWindowHandles()) {
	 
	 
	 driver.switchTo().window(childwindow);
	 
	 
 }
 
 try
 {
	 
	 s_assert.assertTrue(false,driver.getTitle()+"   Passed tcs");
 }catch(Exception e) {
	 
	 
	 s_assert.assertTrue(false,driver.getTitle()+"   Failed tcs");
	 
 }
 
 
 

 
 
 
 
 System.out.println(driver.getTitle());
 		 
		 
 driver.close();
 
 driver.switchTo().window(Parentwindow);
 
 driver.close();
 
 s_assert.assertAll();
 
 
 
 
 
 }
}



