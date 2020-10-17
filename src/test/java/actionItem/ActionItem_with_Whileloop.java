package actionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionItem_with_Whileloop {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("incognito");
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

            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.name("q")).sendKeys(Hobbies[i]);
            Thread.sleep(1000);
            driver.findElement(By.id("sb_hidden")).submit();
            Thread.sleep(2000);
            String result = driver.findElement(By.className("sb_count")).getText();
            String[] arrayResult = result.split(" ");
            System.out.println("My search number for " + Hobbies[i] + " is " + arrayResult[0]);
            i = i + 1;
            //another way of doing it
            //i = i++;

        }//end of while loop
        driver.quit();
    }//end of main method
}//end of Java Class
