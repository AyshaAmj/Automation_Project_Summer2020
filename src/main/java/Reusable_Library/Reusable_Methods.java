package Reusable_Library;

import jxl.common.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {
    static int timeout = 10;

    //custom method to add two integer values
    //void methods only executes the statements inside
    //but doesn't return anything
    public static void add(int a, int b) {
        System.out.println("My result of a & b is " + (a + b));
    }//end of add method

    public static void subtraction(int a, int b) {
        System.out.println("My result of a - b is " + (a - b));
    }//end of subtract method

    public static int returnAdd(int a, int b) {
        int result = a + b;
        System.out.println("My result of a & b is " + result);
        return result;

    }

    public static void scroll(WebDriver driver, int x, int y) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + x + "," + y + ")");
            System.out.println("scroll Down");
        } catch (Exception e) {
            System.out.println("unable to scroll");
        }

    }

    public static String captureText(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            System.out.println("Capturing text from " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text from " + elementName + " " + e);

        }
        return result;

    }

    public static void dropDownByIndex(WebDriver driver, String locator, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = null;
        try {
            System.out.println("Selecting dropdown by index " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            System.out.println("Unable to Select by index " + elementName + " " + e);
        }
    }

    public static void dropDownByVisibleText(WebDriver driver, String locator, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = null;
        try {
            System.out.println("Selecting dropdown by visible Text " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to Select by visible Text " + elementName + " " + e);
        }
    }

    public static void dropDownByValue(WebDriver driver, String locator, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = null;
        try {
            System.out.println("Selecting dropdown by value " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByValue(userValue);
        } catch (Exception e) {
            System.out.println("Unable to Select by Value " + elementName + " " + e);
        }
    }

    public static WebDriver getDriver() {
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

        return driver;
    }//end of get driver


    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, String s, String locator, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        }catch (Exception err){
            System.out.println("Unable to click on element " + err.getMessage());
        }//end of exception
    }//end of click method

    //reusable method to type on any element on any websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            System.out.println("Typing on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).sendKeys(userValue);
            //in case field has pre-populated date and want to clear it store as WebElement
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        }catch (Exception err){
            System.out.println("Unable to type on element " + err.getMessage());
        }//end of exception
    }//end of typing method

    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, String locator, String elementName){
        //define explicit wait
        //WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            System.out.println("Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        }catch (Exception err){
            System.out.println("Unable to submit " + err);
        }//end of exception

    }//end of submit method
    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }
    }//end of type and submit method

    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click by index method
    public static void userKeysByIndex(WebDriver driver,String locator,String userInput, int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
            Thread.sleep(1500);
            element.sendKeys(userInput);
            element.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e.getMessage());
        }
    }//end of click by index method
    public static void clickByJS(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            System.out.println("Clicking by JSE on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            jse.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Unable to click by JSE on " + elementName + " " + e.getMessage());
            Assert.verify(false, "this is not working");
        }

    }//method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }



}}





