package Page_Object_Framework.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Hfirst_Childhealth_Plus extends Abstract_Class {
    ExtentTest logger;
    public Hfirst_Childhealth_Plus(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger= Abstract_Class.logger;
    }//end of constructor method

    @FindBy(linkText = "Get a Recommendation")
    WebElement chpGetaRecommendation;
    @FindBy(xpath = "//*[contains(@class,'external-link-no-pop')]")
    WebElement chpFindADr;
    @FindBy(xpath = "//*[@class='contact-link']")
    WebElement chpContactUs;
    @FindBy(linkText = "Forms & Documents")
    WebElement chpFormsAndDocs;
    @FindBy(linkText = "Renew Your Plan")
    WebElement chpRenewPlan;

    public void clickOnchpGetRecommendation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        logger.log(LogStatus.INFO, "Navigating to Child Health Plus Plans");
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan/#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver, chpGetaRecommendation, "Get a recommendation CHP", logger);
        driver.navigate().back();
    }
    public void clickOnchpFindADr() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Child Health Plus Plans");
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan/#2020");
        Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.click(driver, chpFindADr, "Find a Dr CHP", logger);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

        }

    public void clickOnContactUs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        logger.log(LogStatus.INFO, "Navigating to Child Health Plus Plans");
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan/#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver, chpContactUs, "Contact Us CHP", logger);
        Thread.sleep(4000);
        Reusable_Methods_Loggers_Page_Object.captureResult(driver,chpContactUs,logger,"Contact Information");
    }

    public void clickOnChpFormsAndDocs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        logger.log(LogStatus.INFO, "Navigating to Child Health Plus Plans");
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan/#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver, chpFormsAndDocs, "Forms & Docs CHP", logger);
        //driver.navigate().back();
        //driver.close();
    }

    public void clickOnRenewChpPlan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Child Health Plus Plans");
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan/#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver,chpRenewPlan,"Renew Your CHP Plan",logger);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }


}
