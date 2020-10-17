package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InclassActionItem {
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
        //options.addArguments("headless");

        // defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        ArrayList<String> destination= new ArrayList<>();
        destination.add("Atlantic");
        destination.add("Boston");
        destination.add("Washington");

        for(int i = 0; i < destination.size();i++){
        //navigate to www.hotels.com
        driver.navigate().to("https://www.hotels.com");
        //navigate to hotels.com
        Thread.sleep(2000);
        //2 sec delay
        try {
            System.out.println("Clicking on destination");
            WebElement destination_1 = driver.findElement(By.xpath("//*[@name='q-destination']"));
            destination_1.sendKeys(destination.get(i));

        } catch (Exception err) {
            System.out.println("Unable to click on destination" + err);
        }
        Thread.sleep(1000);
        //delay 1 secs

            if (i == 0) {
                try {
                    WebElement checkin = driver.findElement(By.xpath("//*[@name='q-localised-check-in']"));
                    System.out.println("clicked on first link");
                    checkin.clear();
                    checkin.sendKeys("09/30/20");

                }
                catch(Exception err) {
                    System.out.println("unable to enter check in date" + err);
                }


            } else if (i == 1) {
                driver.findElements(By.xpath("//*[@']")).get(1).click();
                System.out.println("clicked on second link");
            } else if (i == 2) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,3500)");}

            driver.findElements(By.xpath("//*[@']")).get(2).click();
                System.out.println("clicked on third link");
            }
            Thread.sleep(2000);//delay 2 secs


        }

    }

