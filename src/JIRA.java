import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JIRA {

	@Test
	public void testJira() throws InterruptedException {
				
				//Opening the Chrome Browser
				System.setProperty("webdriver.chrome.driver","C:\\Users\\anagrawa\\Downloads\\Softwares\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		        
		        //URL
		        driver.get("https://coxvideo.atlassian.net/secure/Dashboard.jspa");
		        
		        //Login button
		        driver.findElement(By.xpath(" //*[@id='user-options']/a")).click();
		     
		        //username
		        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("anupam.agrawal3@cox.com");
		        driver.findElement(By.xpath("//*[@id='login-submit']")).click();
			     
		        //password
		        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("ammapapa@123");
		        driver.findElement(By.xpath("//*[@id='login-submit']")).click();
			     
		        //Issue link
		        driver.findElement(By.xpath("//*[@id='navigation-app']/div/div/div/div[1]/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/span/a/span[2]/span")).click();
		        
		        Thread.sleep(3000);

		        //Dev new issues link
		        driver.findElement(By.xpath("//*[@id='filter_lnk_15800']/a/span[1]/span")).click();

		        Thread.sleep(3000);
		        String first="//*[@id='content']/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[";
		        String second="]/a/span[1]";
		        
		        String one="//*[@id='content']/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[";
		        String two="]/a/span[2]";
		        
		        System.out.println();
		        System.out.println("**********Dev New Defects*******************");
		        System.out.println();
		       
		        for(int i=1;i<=2;i++) {
		        	 try {
		        	String defectIDs=driver.findElement(By.xpath(first+i+second)).getText();
		        	String defectSummary=driver.findElement(By.xpath(one+i+two)).getText();
		        	driver.findElement(By.xpath(first+i+second)).click();
		        	//release in test
		        	String releaseInText=driver.findElement(By.xpath("//*[@id='customfield_11300-field']/a")).getText();
		        													  //*[@id='customfield_11300-field']/a
		        	System.out.println(defectIDs+" - "+defectSummary+"  -  "+releaseInText);
		        	
		        }catch(Exception e) {
		        	System.out.println("EXCEPTION IN DEV NEW DEFECTS");
		        }
		        }
		        
		        System.out.println();
		        System.out.println("**********P0 Defects*******************");
		        System.out.println();
		        
		        //P0s
		        driver.findElement(By.xpath("//*[@id='filter_lnk_16200']/a/span[1]/span")).click();
		        Thread.sleep(2000);
		        
		        for(int i=1;i<=26;i++) {
		        	try {
		        	String defectIDs=driver.findElement(By.xpath(first+i+second)).getText();
		        	String defectSummary=driver.findElement(By.xpath(one+i+two)).getText();
		        	//driver.findElement(By.xpath(first+i+second)).click();
		        	//release in test
		        	//String releaseInText=driver.findElement(By.xpath("//*[@id='customfield_11300-field']/a")).getText();
		        	System.out.println(i+")"+defectIDs+" - "+defectSummary);
		        	
		        }catch(Exception e) {
		        	System.out.println("EXCEPTION IN P0 DEFECTS");
		        }
		        }
		        
		        System.out.println();
		        System.out.println("**********P1 Defects*******************");
		        System.out.println();
		        
		        //P1s
		        driver.findElement(By.xpath("//*[@id='filter_lnk_16001']/a/span[1]/span")).click();
		        Thread.sleep(2000);
		        
		        for(int i=1;i<=50;i++) {
		        	String defectIDs=driver.findElement(By.xpath(first+i+second)).getText();
		        	String defectSummary=driver.findElement(By.xpath(one+i+two)).getText();
		        	driver.findElement(By.xpath(first+i+second)).click();
		        	Thread.sleep(2000);
		        	
		        	//release in test
		        	
		        	try {
		        		//WebElement RIT=driver.findElement(By.xpath("//*[@id='rowForcustomfield_11300']/div/strong"));
		        		String releaseInText=driver.findElement(By.xpath("//*[@id='customfield_11300-field']/a")).getText();
			        	System.out.println(i+")"+defectIDs+" - "+defectSummary+"  -  "+releaseInText);
		        	}catch(Exception e) {
		        		System.out.println(i+")"+defectIDs+" - "+defectSummary+" - RELEASE NOT FOUND");
		        	}
		        	  	
		        }
		        
		        
		        driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[4]/div[2]/div/a[1]")).click();
		        Thread.sleep(1000);
		        
		        System.out.println("---------------------------------------------------------------------------");
		        
		        for(int j=1;j<=16;j++) {
		        
		        	String defectIDs=driver.findElement(By.xpath(first+j+second)).getText();
		        	String defectSummary=driver.findElement(By.xpath(one+j+two)).getText();
		        	//driver.findElement(By.xpath(first+j+second)).click();
		        	//release in test
		        	//String releaseInText=driver.findElement(By.xpath("//*[@id='customfield_11300-field']/a")).getText();
		        	System.out.println(j+")"+defectIDs+" - "+defectSummary);
		        
		        }
		        Thread.sleep(1000);
		        driver.quit();
		        
		        
		        /*//issue #1
		        String issue1=driver.findElement(By.xpath("//*[@id='key-val']")).getText();
		        System.out.println("1st Issue: "+ issue1);
		        

		        String issueSummary1=driver.findElement(By.xpath("//*[@id='summary-val']")).getText();
		        System.out.println("1st Issue Summary: "+ issueSummary1);
		        Thread.sleep(1000);
		       // String splitSum=issueSummary1.split("Summary")[1].toString().split(": ")[1];
		        //String splitSum=issueSummary1.split("Summary")[1].toString();
		        //String split=issueSummary1.split("Summary")[1];
		        
		        //System.out.println("1st Issue Summary: "+ splitSum);
		       // System.out.println("1st Issue Summary: "+ split);
		        
		      //issue #2
		        driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[2]/a/span[1]")).click();
		        String issue2=driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[2]/a/span[1]")).getText();
		        System.out.println("1st Issue: "+ issue2);
		        String issueSummary2=driver.findElement(By.xpath("//*[@id='summary-val']")).getText();
		        //Thread.sleep(1000);
		        System.out.println("2nd Issue Summary: "+ issueSummary2);

		        //String splitSum1=issueSummary2.split("Summary")[1];
		        //System.out.println("2nd Issue Summary: "+ splitSum1);
*/
	}

}
