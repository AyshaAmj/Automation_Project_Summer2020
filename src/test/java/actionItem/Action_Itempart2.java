package actionItem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

import static org.openqa.selenium.Keys.ENTER;

public class Action_Itempart2 {
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

        System.out.println("navigating to ww website");
        driver.navigate().to("https://www.weightwatchers.com");
        //driver.manage().window().maximize();(for Mac users)
        //delay 2 seconds
        Thread.sleep(2000);

        //capture the homepage title and verify it matches the expected title
        //which is "Weight Watchers: Weight Loss & Welness Help"
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle == "Weight Watchers: Weight Loss & Welness Help") {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//end of conditional statement

        ArrayList<String> zipCodeList = new ArrayList<>();
        zipCodeList.add("11204");
        zipCodeList.add("10010");
        zipCodeList.add("10314");

        //call the for loop to iterate through the array list
        for (int i = 0; i < zipCodeList.size(); i++) {
            //navigate to ww page
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

         //clicking on Find a workshop link
         try {
                System.out.println("Clicking on Find a workshop link");
                driver.findElement(By.xpath("//*[@class='Button_button__RwVHT MenuItem_menu-item__link__2qTtx SecondaryMenu_menuItem__1m5Ya Button_button--no-style__3CpTl']")).click();
         } catch (Exception err) {
                System.out.println("Unable to click on Find a workshop link " + err);
            }//end of click on Find a workshop link exception

            Thread.sleep(5000);

            //entering zipcode
        try {
                System.out.println("Entering zipcode");
                WebElement zipCode = driver.findElement(By.xpath("//*[@id='location-search']"));
                zipCode.sendKeys(zipCodeList.get(i));
                System.out.println("pressing Enter");
                zipCode.sendKeys(ENTER);//pressing enter
        } catch (Exception err) {
                System.out.println("Unable to enter zipcode " + err);
            }//end of zipcode exception

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down using executeScript command
            jse.executeScript("scroll(0,500)");

            Thread.sleep(2000);//delay 2secs

        if (i == 0) {
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                System.out.println("clicked on first link");
         } else if (i == 1) {
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
                System.out.println("clicked on second link");
         } else if (i == 2) {
                jse.executeScript("scroll(0,500)");
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                System.out.println("clicked on third link");
            }
            Thread.sleep(2000);//delay 2 secs

         try {
                String addressResults = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                String addressResult = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                System.out.println(addressResults);
                System.out.println("Address is " + addressResults + addressResult);
        } catch (Exception err) {
                System.out.println("Unable to capture address " + err);
            }


                //scroll down using executeScript command
                jse.executeScript("scroll(0,900)");

                //capture and print Schedule
        try {
                    System.out.println("Capturing weekly schedule");
                    String schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();
                    System.out.println("My weekly schedule is " + schedule);
        } catch (Exception err) {
                    System.out.println("Unable to capture schedule " + err);
                }//end of print schedule exception

            }driver.quit();
        }//end of main method
    }//end of java class