package actionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionItem_Yahoo {
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

        WebDriver driver = new ChromeDriver(options);

        String[] Hobbies = new String[5];
        Hobbies[0] = "Traveling";
        Hobbies[1] = "Puzzles";
        Hobbies[2] = "Shopping";
        Hobbies[3] = "Knitting";
        Hobbies[4] = "Dancing";

        int i = 0;
        while(i < Hobbies.length){

            driver.navigate().to("https://www.yahoo.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.name("p")).sendKeys(Hobbies[i]);
            Thread.sleep(1000);
            driver.findElement(By.id("ybar-sbq-x")).submit();
            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            //String result;
            //String[] Result = new String[0];
            //String arrayResult = driver.findElement(By.xpath(//*[@id="yui_3_10_0_1_1600228216527_676"])).getText()
            //String Result= arrayResult.split(" ");
            //System.out.println("My search number for " + Hobbies[i] + " is " + Result[0]);
            i = i + 1;
            //another way of doing it
            //i = i++;

        }//end of while loop
        driver.quit();

    }//end of main method

}//end of Java class
