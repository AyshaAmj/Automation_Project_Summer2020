package actionItem;

import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class FedEx_AI extends Abstract_Class_Cross_Browser {
    @Test
    public void FedEx() throws InterruptedException {

        driver.manage().deleteAllCookies();
        logger.log(LogStatus.INFO, "Navigating to FedEx home page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(3000);

        Reusable_Methods_Loggers.click(driver, "//*[contains(@class,fxg-dropdown__item) and @aria-label='Open Design & Print menu']","Design & Print",logger);
        Reusable_Methods_Loggers.click(driver, "//*[text()='Upload a Print-Ready File']","Upload & Print", logger);
        Thread.sleep(2500);
        String actualTitle = driver.getTitle();
        //verify it matches the expected title
        if (actualTitle.contains("FedEx Office Print")) {
            System.out.println("Title matches");
            logger.log(LogStatus.PASS,"Title Matches" + actualTitle);
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Title doesn't match.Actual title is " + actualTitle);
        }
        Thread.sleep(2500);
        Reusable_Methods_Loggers.click(driver, "//*[text()='Document Printing']", "Document Printing",logger);
        Thread.sleep(3000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='product-image']", "Copies & Custom Project",logger);
        Reusable_Methods_Loggers.click(driver,"//*[text()='Use Your File']","Use your File",logger);
        Thread.sleep(2000);
        Reusable_Methods_Loggers.uploadFile("C:\\Users\\Ash\\Pictures\\Screenshots\\Screenshot (4).png");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[text()='CONTINUE WITH EXISTING']","Continue w/ Existing",logger);
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@class='quantity-field']","5",logger,"Quantity");
        Thread.sleep(1000);
        Reusable_Methods_Loggers.click(driver,"//*[text()='Add to cart']","Add to Cart",logger);
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='cartToCheckoutBtn']","Checkout",logger);
        Thread.sleep(1000);
        Reusable_Methods_Loggers.click(driver,"//*[text()='Proceed as guest']","Proceeding as guest",logger);
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='radiusSelect']","Radius",logger);
        Thread.sleep(1000);
        Reusable_Methods_Loggers.click(driver,"//*[@value='5']","5 Miles",logger);
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@id='loc_seacrh_text']","11218",logger,"ZipCode");
        Thread.sleep(2500);
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@id='5732']",logger,"Brooklyn & Nostrand ave");
        logger.log(LogStatus.INFO,"My address is  " + result);
        System.out.println("My address is " + result);


    }//End of @Test
}//End of FedEx_AI class
