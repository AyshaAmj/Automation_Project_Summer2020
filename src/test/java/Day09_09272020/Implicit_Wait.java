package Day09_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Implicit_Wait {

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

        //set the implicit wait before your test steps
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com");
        //Thread.sleep(2000);
        //enter search keyword
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //click on search
        driver.findElement(By.xpath("//*[@name='btnk']")).submit();
    }
}
