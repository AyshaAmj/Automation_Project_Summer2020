package actionItem;

import Day3_09062020.Reusable_Methods;
import com.google.common.base.MoreObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.openqa.selenium.Keys.ENTER;

public class Action_Item09202020 {
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
        options.addArguments("headless");

        // defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        //System.out.println("navigating to ww website");
        driver.navigate().to("https://www.weightwatchers.com");
        //driver.manage().window().maximize();(for Mac users)
        //delay 2 seconds
        Thread.sleep(2000);

        //capture the homepage title and verify it matches the expected title
        //which is "Weight Watchers: Weight Loss & Welness Help"
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle == "Weight Watchers: Weight Loss & Welness Help"){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//end of conditional statement

        ArrayList<String> zipCodeList = new ArrayList<>();
        zipCodeList.add("11204");
        zipCodeList.add("10010");
        zipCodeList.add("10314");

        //call the for loop to iterate through the array list
        for (int i = 0; i < zipCodeList.size(); i++){
            //navigate to ww page
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            //clicking on Find a workshop link
            try {
                System.out.println("Clicking on Find a workshop link");
                driver.findElement(By.xpath("//*[@class='Button_button__RwVHT MenuItem_menu-item__link__2qTtx SecondaryMenu_menuItem__1m5Ya Button_button--no-style__3CpTl']")).click();
            }catch (Exception err) {
            System.out.println("Unable to click on Find a workshop link " + err);
            }//end of click on Find a workshop link exception

            Thread.sleep(15000);

            try {
                System.out.println("Entering zipcode");
                WebElement zipCode = driver.findElement(By.xpath("//*[@id='location-search']"));
                //zipCode.clear();
                zipCode.sendKeys(zipCodeList.get(i));
                System.out.println("pressing Enter");
                zipCode.sendKeys(ENTER);
            }catch (Exception err){
                System.out.println("Unable to enter zipcode " + err);
            }//end of purchase zipcode exception

            WebElement alert = driver.findElement(By.xpath("//*[@class='bx-close-x-adaptive-2']"));
            WebDriverWait wait = new WebDriverWait(driver,10);
            if(alert.isDisplayed()){
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='bx-close-x-adaptive-2']")));
                alert.click();
            }else{
                //need to scroll to the bottom of the page to capture the search result
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //scroll down using executeScript command
                jse.executeScript("scroll(0,500)");

            }
            Thread.sleep(5000);
            //Reusable_Methods.scroll(driver,0,700);
            WebElement location = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0);
            location.click();
            System.out.println("clicked on first link");
            Thread.sleep(2000);

            WebElement alert2 = driver.findElement(By.xpath("//*[@class='bx-close-x-adaptive-2']"));
            WebDriverWait wait2 = new WebDriverWait(driver,10);
            if(alert2.isDisplayed()){
                wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='bx-close-x-adaptive-2']")));
                alert.click();
            }else{
                //need to scroll to the bottom of the page to capture the search result
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //scroll down using executeScript command
                jse.executeScript("scroll(0,500)");
                Thread.sleep(2500);

            }
            try {

                String addressResults = driver.findElements(By.xpath("//*[@class='address-3-YC0']")).get(0).getText();
                System.out.println(addressResults);
                System.out.println("Address is " + addressResults);
            } catch (Exception err){
                System.out.println("Unable to capture address " + err);
            }

            //need to scroll to the bottom of the page to capture the search result
            JavascriptExecutor jse = (JavascriptExecutor) driver;
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






           /* WebElement sunday = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(0);
            String sundayResults = sunday.getText();
            System.out.println("Printing results for Sunday");
            System.out.println(sundayResults);

            WebElement monday = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(1);
            String mondayResults = monday.getText();
            System.out.println("Printing results for Monday");
            System.out.println(mondayResults);

            WebElement tuesday = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(2);
            String tuesdayResults = tuesday.getText();
            System.out.println("Printing results for tuesday");
            System.out.println(tuesdayResults);

            WebElement wednesday= driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(3);
            String wednesdayResults = wednesday.getText();
            System.out.println("Printing results for wednesday");
            System.out.println(wednesdayResults);

            WebElement thursday = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(4);
            String thursdayResults = thursday.getText();
            System.out.println("Printing results for thursday ");
            System.out.println(thursdayResults);

            WebElement friday= driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(5);
            String fridayResults = friday.getText();
            System.out.println("Printing results for friday");
            System.out.println(fridayResults);

            WebElement saturday = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(6);
            String saturdayResults = saturday.getText();
            System.out.println("Printing results for saturday");
            System.out.println(saturdayResults);*/

            //WebElement schedule = driver.findElements(By.xpath("//*[@class='day-NhBOb']")).get(i);
            //String scheduleResults = schedule.getText();
            //System.out.println("printing results" + schedule.getText());

        }//end of for loop
    driver.quit();

    }//end of main method
}//end of java class
