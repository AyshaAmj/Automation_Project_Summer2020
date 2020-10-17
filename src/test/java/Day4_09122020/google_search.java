package Day4_09122020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search {
    public static void main(String[] args) throws InterruptedException {

        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver();

        //let's get to google home page
        //driver.get("https://www.google.com");

        //let's navigate to google home page
        driver.navigate().to("https://www.google.com");
        //maximize my window
        driver.manage().window().maximize();
        //put two second delay
        Thread.sleep(2000); //everytime u make a new class u have to add the exception for Thread
        //locate search field by name and enter a keyword on the field
        driver.findElement(By.name("q")).sendKeys("cars");
        //handling delay by using sleep command
        Thread.sleep(1000);
        //click on google search
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).submit(); // hitting enter is same as submit


        //close driver
        //driver.close();
        //quit the entire session
        driver.quit();

    }//end of main method

}//end of java class
