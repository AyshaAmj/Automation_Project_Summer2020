package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Yahoo_with_xpath {
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

        //navigate to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        //delay 2 secs
        Thread.sleep(2000);

        //type a keyword on yahoo search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        //click/submit on search button
        driver.findElement(By.xpath("//*[@value='Search']")).click();
        //delay 2 to 3 secs
        Thread.sleep(2500);
        //need to scroll to the bottom of the page to capture the search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll down using executeScript command
        jse.executeScript("scroll(0,5000)");
        //capture the entire footer including the result from yahoo result page
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        //need to split by Next to separate the search result
        String[] arrayResult = result.split("Next");
        //need to split again to only capture the number
        String[] searchResult = arrayResult[1].split(" ");
        //print out the number you are looking for
        System.out.println("My search number is " + searchResult[0]);
        Thread.sleep(1000);
        //let's go back to top of page
        jse.executeScript("scroll(0,-5000)");

        //driver.quit



    }//end of main method

}//end of java class
