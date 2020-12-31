package Page_Object_Framework.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Hfirst_Essential_Plans extends Abstract_Class {
    ExtentTest logger;

    public Hfirst_Essential_Plans(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Abstract_Class.logger;
    }//end of constructor method

    @FindBy(linkText = "Get a Recommendation")
    WebElement getRecommendationForEssentialPlans;
    @FindBy(xpath = "//*[contains(@class,'external-link-no-pop')]")
    WebElement findADoctorEssential;
    @FindBy(linkText = "Forms & Documents" )
    WebElement formsAndDocsEssentialPlans;
    @FindBy(linkText = "Renew Your Plan")
    WebElement renewEssentialPlan;
    @FindBy(xpath = "//*[contains(text(),'More Plan Information')]")
    WebElement moreEssentialPlanInfo;
    @FindBy(xpath="//*[text()='See All']")
    WebElement frequentlyAskedQs;

        public void clickOnGetRecommendationEP() throws InterruptedException {

         WebDriverWait wait = new WebDriverWait(driver, 5);
         logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
         driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
         Thread.sleep(3000);

         Reusable_Methods_Loggers_Page_Object.click(driver, getRecommendationForEssentialPlans, "Get Recommendation", logger);
         driver.navigate().back();
     }

        public void clickFindDrEP() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
            driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
            Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.click(driver, findADoctorEssential, "Find a Dr", logger);
            //driver.navigate().back();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //driver.switchTo().window(tabs.get(0));
            //driver.close();
        }
        public void clickOnFormsAndDocsEP() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
            driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
            Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.click(driver, formsAndDocsEssentialPlans, "Forms & Docs", logger);
            //driver.navigate().back();
            //driver.close();
        }
        public void clickOnRenewEssentialPlan() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
            driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
            Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.click(driver, renewEssentialPlan, "Renew Essential Plan", logger);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

        }
        public void clickOnMorePlanInfo() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
            driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
            Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.scroll(driver, 0, 600);
            Reusable_Methods_Loggers_Page_Object.click(driver, moreEssentialPlanInfo, "More Plan Info", logger);
            //driver.close();
        }
        public void clickOnFaqEP() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            logger.log(LogStatus.INFO, "Navigating to Health First Essential Plan Object Page");
            driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
            Thread.sleep(3000);

            Reusable_Methods_Loggers_Page_Object.scroll(driver,0,800);
            Reusable_Methods_Loggers_Page_Object.click(driver,frequentlyAskedQs,"FAQs",logger);
            driver.navigate().back();
            driver.close();
        }

    }

