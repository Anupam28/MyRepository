import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ant {
	
	
	
	
	@Test
	public void testAnt() {
		System.out.println("Welcome to the Ant project");
		
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anagrawa\\Downloads\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
       
        driver.get("https://facebook.com");
       
        System.out.println("Executing ANT Project from Jenkins");
        System.out.println("Execution of ANT Project from Jenkins is COMPLETED");
	}

}
