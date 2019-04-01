package genericMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassGeneric {
	
	
	protected WebDriver driver;
	
	public void navigateHome_page() {
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","/MavenTest/src/main/resources/Drivers/chromedriver.exe");
		 driver.get("https://www.hdfcbank.com/");
	}
	
	public void clk_homepageobj() throws InterruptedException {
		
		
		WebElement textlog = driver.findElement(By.xpath("//*[@id=\"loginsubmit\"]"));
		
		textlog.click();
		
	}
	
	public void switchwindow() {
		
		String parent_window=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
	{

		String child_window=i1.next();
		
		if(!parent_window.equalsIgnoreCase(child_window))
		{
		
			driver.switchTo().window(child_window);
			
		}
	}
	}
		public void childwindow() {
		
		WebElement txtchdwnd = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a"));
		System.out.println("child Window "+txtchdwnd.getText());
		
		
	}
	
	public void closethewindow()
	{
		driver.switchTo().defaultContent();
		
		
	}
	
	public void getparenttxt() {
		
		WebElement parenttxt = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[1]/a"));
		
		System.out.println("Parent Window   "+driver.getTitle());
		
		
		
		parenttxt.click();
	}
	
	
	
	public static String navigatetohom(WebDriver driver) {
		
		    String parentWindow= driver.getWindowHandle();
		    return parentWindow;
		
	}
	
	
	
	
	
}
