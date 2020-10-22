package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.common.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class Reusable_Methods_Loggers {

    public static WebDriver getDriver() throws IOException {
        //killnall chrome driver instance before opening a new one
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver86.exe/chromedriver.exe");
        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");
        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here
        return driver;
    }//end of get driver

    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method

    //reusable method to click on any element on any websites
    public static void clickByIndex(WebDriver driver, String locator, Integer indexNumber, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(indexNumber).click();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method

    //reusable method to type on any element on any websites
    public static void sendKeys(WebDriver driver, String locator, String userValue, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Typing on element " + elementName);
            logger.log(LogStatus.INFO, "Typing on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to type on element " + err);
            logger.log(LogStatus.FAIL, "Unable to type on element " + err);
        }//end of exception
    }//end of sendkeys method

    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Submitting on element " + elementName);
            logger.log(LogStatus.INFO, "Submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on element " + err);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + err);
        }//end of exception
    }//end of submit method

    //reusable method to capture a value/text from a page
    public static String captureResult(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            System.out.println("Capturing text on element " + elementName);
            logger.log(LogStatus.INFO, "Capturing text on element " + elementName);
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
        } catch (Exception err) {
            System.out.println("Unable to capture text on element " + err);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + err);
        }//end of exception

        return result;
    }//end of get result method

    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, String locator, String userInput, ExtentTest elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            System.out.println("\nSelecting " + userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);

        } catch (Exception err) {
            System.out.println("Unable to select from drop down " + err);
        }
    }//end of drop down by text method


    public static void typeAndSubmit(WebDriver driver, String locator, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
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


    //method to click on an element
    public static void mouseClick(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.INFO, "Clicked" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Didn't work");
        }
    }//end of click method

    public static void scroll(WebDriver driver, int x, int y) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + x + "," + y + ")");
            System.out.println("scroll Down");
        } catch (Exception e) {
            System.out.println("unable to scroll");
        }

    }

    public static void mouseHover(WebDriver driver, String locator, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        WebElement element = null;
        try {
            System.out.println("Mouse hovering over" + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover over " + elementName + "" + e.getMessage());

        }
    }

    public static void mouseHoverIndex(WebDriver driver, String locator, int indexNumber, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            System.out.println("Clicking on element " + elementName);
            List<WebElement> element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
            actions.moveToElement(element.get(indexNumber)).perform();
        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
        }//end of exception
    }//end of click method

    public static void dropDownByIndex(WebDriver driver, String locator, ExtentTest logger, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = null;
        try {
            System.out.println("Selecting dropdown by index " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByIndex(index);
            logger.log(LogStatus.INFO, "clicking on index" + index);
        } catch (Exception e) {
            System.out.println("Unable to Select by index " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on" + e.getMessage());
        }
    }

    public static void clickByJS(WebDriver driver, String locator, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            System.out.println("Clicking by JSE on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            jse.executeScript("arguments[0].click();", element);
            logger.log(LogStatus.INFO, "Clicking on element by js" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click by JSE on " + elementName + " " + e.getMessage());
            Assert.verify(false, "this is not working");
            logger.log(LogStatus.FAIL, "Unable to click on element" + e.getMessage());
        }

    }//method to click on an element

    //method to upload a file(image,doc, etc...) from your computer by using robot command
    public static void uploadFile(String fileLocation) {
        try { //Setting clipboard with file location
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }//end of uploadFile method
}













