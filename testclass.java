package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testclass {

  public static void main(String[] args){
    //Setting the driver path
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    
    //Creating WebDriver instance
    WebDriver driver = new ChromeDriver();
    
    //Navigate to web page
    driver.get("https://followart.uat.videinfra.net/login");
    
    //Maximizing window
    driver.manage().window().maximize();
    
    //Retrieving web page title
    String title = driver.getTitle();
    System.out.println("The page title is : " +title);
    
    //Locating web element
    WebElement uName = driver.findElement(By.xpath("//*[@name='username']"));
    WebElement pswd = driver.findElement(By.xpath("//*[@name='password']"));
    WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
    
    
    //Peforming actions on web elements
    uName.sendKeys("admin@example.com");
    pswd.sendKeys("admin");
    loginBtn.submit();
    
    //Putting implicit wait
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    
    try {
    	WebElement m = driver.findElement(By.xpath("//*[@id=\"profile-menu\"]")); 
    	m.click();
      //Locating web element
      WebElement logoutBtn = driver.findElement(By.xpath("//a[@href='/logout']"));
      //Validating presence of element        
      //if(logoutBtn.isDisplayed()){
        
        //Performing action on web element
        logoutBtn.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("LogOut Successful!");
      //}
    } 
    catch (Exception e) {
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
  
            // Prints what exception has been thrown
            System.out.println(e);
      System.out.println("Incorrect login....");
    }
    
    //Closing browser session
    driver.quit();
    
  }

}