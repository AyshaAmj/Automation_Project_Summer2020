package Day09_09272020;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableMethod_AppleSite {
    public static void main(String[] args) {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

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

        driver.navigate().to("https://www.apple.com");

        //calling the reusable click method for clicking on mac link
        Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@data-analytics-title='mac']","Mac Link");
        //click on mac book air
        Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[text()='MacBook Air']","Mac Book Air");
        //click on search icon
        //Thread.sleep(2000);
        Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@id='ac-gn-link-search']","Search Icon");
        //entering a keyword on search field
        Reusable_Methods.sendKeys(driver,"//*[@placeholder='Search apple.com']","iphone","Search Field");
        //hit submit
        Reusable_Methods.submit(driver,"//*[@placeholder='Search apple.com']","Search Field");


    }//end of main method


}//end of java class
