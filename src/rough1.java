
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.tools.JavaFileObject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class rough1 {

	@Test
	public void testCVM() throws InterruptedException {
		
		//Opening the Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\anagrawa\\Downloads\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        
        //Reading data from Excel file
        Xls_Reader xls=new Xls_Reader("C:\\Users\\anagrawa\\Downloads\\Documents\\TestBook.xlsx");
        int rows=xls.getRowCount("MasterSheet");
        //System.out.println("Total Rows: "+rows);
        
        //Application URL
        driver.get("https://dukecvappadmin00.tc.at.cox.net:8443/adminui/main.html");
        
        //Login
        driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("anagrawa");
        driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("Papaamma@123");
        driver.findElement(By.xpath("//*[@id='login-submit']")).click();
        
        //Diagnostic->Customer Diagnostics selection
        WebElement diagnostics=driver.findElement(By.xpath("//*[@id='feature-menu-area']/div/div[1]/span"));
        
        //mouse movement over Diagnostics
        Actions act=new Actions(driver);
        act.moveToElement(diagnostics).build().perform();
        
        //Clicking Customer Diagnostics
        driver.findElement(By.xpath("//*[@id='feature-menu-area']/div/div[1]/ul/li[2]")).click();
        
        
        for(int i=2;i<=10;i++) {
        	String serialNo=xls.getCellData("MasterSheet", "SN", i);
        	
        	if(!serialNo.isEmpty()) {
        	System.out.println("SN: "+serialNo);
        	driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/input")).sendKeys(serialNo);
        	driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/button")).click();
        	
        	Thread.sleep(2000);
        	
        	String accountNo=driver.findElement(By.xpath("//span[@class='cls_AccountNumber']")).getText();
        	System.out.println("Account No.: "+accountNo);
        	xls.setCellData("MasterSheet", "AccountNo", i, accountNo);
        	
            //String macID=driver.findElement(By.xpath("//span[@class='cls_MacAddress']")).getText();
            //System.out.println("MAC ID: "+macID);
            //xls.setCellData("Sheet1", "MAC_ID", i, macID);
            
           /* String deviceGUID=driver.findElement(By.xpath("//*[@id='custdiag-1']/div/div[2]/form[2]/fieldset/table/tbody/tr[2]/td/span")).getText();
            System.out.println("Device GUID: "+deviceGUID);
            xls.setCellData("Sheet1", "Device GUID", i, deviceGUID);
            
            //Click Analyze button
       
            driver.findElement(By.xpath("//*[@id='custdiag-1']/div/div[2]/button")).click();
            Thread.sleep(2000);
            String deviceID=driver.findElement(By.xpath("//*[@id='custdiag-1']/div/div[3]/div[2]/pre")).getText();
           
            String x1DeviceID=deviceID.split("\"x1DeviceID\":")[1].toString().split(",")[0].replaceAll("\"", "");
        	System.out.println("x1 Device ID: "+x1DeviceID);
        	xls.setCellData("Sheet1", "DeviceID", i, x1DeviceID);
        	
        	String macID=deviceID.split("\"hostMac\":")[1].toString().split(",")[0].replaceAll("\"", "");
        	System.out.println("MAC ID: "+macID);
        	xls.setCellData("Sheet1", "MAC_ID", i, macID);*/
            
            System.out.println(" ");
            driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/input")).clear();
        	}
            
        }
        
        
        /*
        
        //Enter SN in the text field
        driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/input")).sendKeys("M11539TE3033");
        
        //click Search button
        driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/button")).click();
        
        Thread.sleep(1000);
        //Click Analyze button
        driver.findElement(By.xpath("//*[@id='custdiag-1']/div/div[2]/button")).click();
        
        Thread.sleep(1000);
        
        
        //Get Device ID
        String deviceID=driver.findElement(By.xpath("//*[@id='custdiag-1']/div/div[3]/div[2]/pre")).getText();
        
     //   ,"x1DeviceID":"2819178379036507606","x1ServiceAccountId":"9073087740871461403","billingAccountId":"de220235-b6f0-4a9c-b199-3f86239e04be","ecmMAC":"3C:DF:A9:E7:64:5E","dvrCapacity":"2006464512","dvrCapacityUnits":"KB","dvrStorage":2006464512,"x1DeviceGUID":null,"x1ServiceAccountAdded":1513025135869,"x1ServiceAccountUpdated":1513260649641,"status":"Active","deviceName":"","deviceType":"QamIpStb","make":"Arris","model":"AX013ANM","serialNumber":"M11539TE3036","hostMac":"20:3D:66:B0:7D:83","mocaMAC":"20:3D:66:B0:7E:82","emtaMAC":"","wanMAC":"","ethMAC":"20:3D:66:B0:7D:82","hasDvr":true,"dvrNumTuners":6,"numTuners":6,"deviceFeatures":"dvr6"}
        
        String x1DeviceID=deviceID.split("\"x1DeviceID\":")[1].toString().split(",")[0].replaceAll("\"", "");
        
        System.out.println("x1 Device ID: "+x1DeviceID);
        
        
        String accNo=deviceID.split("\"x1DeviceID\":")[1].toString().split(",")[0].replaceAll("\"", "");
        
        String macID=deviceID.split("\"hostMac\":")[1].toString().split(",")[0].replaceAll("\"", "");
        System.out.println("MAC ID: "+macID);
        
        
        
        
        //System.out.println(deviceID.split("\"x1DeviceID\":")[1].toString().split(",")[0].replaceAll("\"", ""));
            
        
        //clear the text field
        driver.findElement(By.xpath("//*[@id='working-content']/div/div[1]/div/div[1]/input")).clear();
        
        */
          
     

        
        
        

	}

}
