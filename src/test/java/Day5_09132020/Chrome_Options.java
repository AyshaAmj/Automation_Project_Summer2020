package Day5_09132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {

    public static void main(String[] args) throws InterruptedException  {

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

        //navigate to google page
        //System.out.println("navigating to google home page");
        driver.navigate().to("https://www.google.com");
        //driver.manage().window().maximize();(for Mac users)
        //delay 2 seconds
        Thread.sleep(2000);

        //capture the homepage title and verify it matches the expected title
        //which is GOOGLE
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle == "GOOGLE"){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match.Actual title is " + actualTitle);
        }//end of conditional statement

    }


}//end of java class
