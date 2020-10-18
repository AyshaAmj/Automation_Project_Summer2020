package actionItem;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InClassActionItem extends Abstract_Class {

    @Test
    public void Yahoo_AI()throws InterruptedException {
    logger.log(LogStatus.INFO, "Navigating to www.yahoo.com");
    Thread.sleep(2000);
    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(3000);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(driver.getTitle(),"Yahoo");
    List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
    //Print out the link count
        System.out.println("Link count is " + linkCount.size());
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@id='ybar-sf']","Nutrition",logger,"Search Field");
        Reusable_Methods_Loggers.scroll(driver,0,5000);
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='compPagination']",logger,"Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[6]);
        Reusable_Methods_Loggers.scroll(driver,0,-5000);
        Reusable_Methods_Loggers.click(driver,"//*[text()='Images']","Images",logger);
        List<WebElement> ammountOfLinks =driver.findElements(By.xpath("//*[contains(@id,'yui_3_5_1_1_1']"));
        System.out.println("Amount of image links" + ammountOfLinks.size());
        Reusable_Methods_Loggers.click(driver,"//*[@class='text signin']","Sign In",logger);
        Thread.sleep(5000);
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        Thread.sleep(2500);
        if (checkboxState == true){
            System.out.println("Checkbox is selected as expected");
        }else {
            System.out.println("Checkbox is not selected by default");
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='login-username']","98oi87",logger,"Enter username");
        Reusable_Methods_Loggers.click(driver,"//*[@id='login-signin']","Click sign in",logger);
        Reusable_Methods_Loggers.captureResult(driver,"//*[@id='username-error']",logger,"Invalid username");

    }


}}
