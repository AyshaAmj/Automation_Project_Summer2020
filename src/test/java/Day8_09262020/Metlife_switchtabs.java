package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Metlife_switchtabs {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");

        // defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();//click on take along dental
        //click on take along dental
        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(1500);
        //anytime theres white space in front of text use 'contains' so it ignores the space
        //anytime its black text use text instead of @
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click(); //click Enroll Now

        //need to store get window handles command in as ArrayList to switch to different tab(s)
        //only when u open 2nd tab u call array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));

        //enter zipcode
        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11218");
        driver.close();//to close the new tab if you don't need it again
        //switch back to previous tab
        driver.switchTo().window(tabs.get(0));
        //re-navigate back to met life
        driver.navigate().to("https://www.metlife.com");


    }//end of main method
}//end of java class
