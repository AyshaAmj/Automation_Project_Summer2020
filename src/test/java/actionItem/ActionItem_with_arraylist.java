package actionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_with_arraylist {
    public static void main(String[] args) throws InterruptedException {

        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        options.addArguments("headless");

        // defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here


        //lets create an ArrayList to handle multiple boroughs on google search
        ArrayList <String> boroughs = new ArrayList <String> ();
        boroughs.add("Brooklyn");
        boroughs.add("Queens");
        boroughs.add("Manhattan");
        boroughs.add("Bronx");
        boroughs.add("Staten Island");

        for (int i = 0; i < boroughs.size(); i++) {
            /* let's navigate to google home page */
            driver.navigate().to("https://www.google.com");

            //maximize my window
            driver.manage().window().maximize();

            //put two second delay
            Thread.sleep(2000); //everytime u make a new class u have to add the exception for Thread

            /**--------------------------------------------------------------------------------------------
            locate search field by name and enter a keyword on the field
            In an arraylist we write boroughs.get(i)
            In a dynamic or liner array we write boroughs[i]---------------------------------------------**/
            driver.findElement(By.name("q")).sendKeys(boroughs.get(i));

            //handling delay by using sleep command
            Thread.sleep(1000);

            //click on google search
            //driver.findElement(By.name("btnK")).click();
            driver.findElement(By.name("btnK")).submit(); // hitting enter is same as submit
            Thread.sleep(2000);

            //capture the search result text
            String result = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = result.split(" ");

            //print out the search number
            System.out.println("My search number for " + boroughs.get(i) + " is " +  arrayResult[1]);


        }//end of for loop
        driver.quit();//quit driver
    }

}//end of Class
