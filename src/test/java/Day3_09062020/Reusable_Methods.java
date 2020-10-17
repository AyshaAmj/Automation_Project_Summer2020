package Day3_09062020;

import com.sun.source.tree.TryTree;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods{

    //custom method to add two integer values
    //void methods only executes the statements inside
    //but doesn't return anything
    public static void add(int a, int b){
        System.out.println("My result of a & b is " + (a+b));
    }//end of add method

    public static void subtraction(int a, int b){
        System.out.println("My result of a - b is " + (a-b));
    }//end of subtract method

    public static int returnAdd(int a, int b){
        int result = a+b;
        System.out.println("My result of a & b is " + result);
        return result;

    }

    public static void scroll(WebDriver driver, int x, int y){
        try{
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll("+ x + ","+ y + ")");
            System.out.println("scroll Down");
        }catch (Exception e){
            System.out.println("unable to scroll");
        }

    }
    public static String captureText(WebDriver driver, String locator, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = null;
        try{
            System.out.println("Capturing text from " + elementName);
            WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My result is " + result);
        }catch (Exception e){
            System.out.println("Unable to capture text from " + elementName + " " + e);

        }
        return result;

    }
    public static void dropDownByIndex(WebDriver driver, String locator, int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = null;
        try{
            System.out.println("Selecting dropdown by index " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByIndex(index);
        }catch (Exception e){
            System.out.println("Unable to Select by index " + elementName + " " + e);
        }
    }
    public static void dropDownByVisibleText(WebDriver driver, String locator, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = null;
        try{
            System.out.println("Selecting dropdown by visible Text " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByVisibleText(userValue);
        }catch (Exception e){
            System.out.println("Unable to Select by visible Text " + elementName + " " + e);
        }
    }
    public static void dropDownByValue(WebDriver driver, String locator, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = null;
        try{
            System.out.println("Selecting dropdown by value " + elementName);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByValue(userValue);
        }catch (Exception e){
            System.out.println("Unable to Select by Value " + elementName + " " + e);
        }
    }

}//end of java class
