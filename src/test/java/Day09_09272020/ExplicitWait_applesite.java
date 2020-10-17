package Day09_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait_applesite {

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

        //declare explicit wait command only once
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //navigate to apple site
        driver.navigate().to("https://www.apple.com");
        //Thread.sleep(1500);
        //click on mac link using explicit wait
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-analytics-title='mac']"))).click();
    }
}
