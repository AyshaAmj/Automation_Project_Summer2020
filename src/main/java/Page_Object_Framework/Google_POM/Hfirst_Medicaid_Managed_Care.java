package Page_Object_Framework.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers;
import Reusable_Library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Hfirst_Medicaid_Managed_Care extends Abstract_Class {
    ExtentTest logger;

    public Hfirst_Medicaid_Managed_Care(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor method

    @FindBy(linkText = "Get a Recommendation")
    WebElement getRecommendation;
    @FindBy(xpath = "//*[contains(@class,'external-link-no-pop')]")
    WebElement findADoctor;
    @FindBy(xpath = "//*[@class='contact-link']")
    WebElement contactUs;
    @FindBy(xpath = "//*[text()='1-844-488-1486']")
    WebElement contactInfo;
    @FindBy(linkText = "Forms & Documents")
    WebElement formsAndDocuments;
    @FindBy(linkText = "Renew Your Plan")
    WebElement renewPlan;
    @FindBy(xpath = "//*[@class='tier-comparison-table']")
    WebElement morePlanInfo;
    @FindBy(xpath = "//*[text()='Costs & Benefits']")
    WebElement costsAndBenefits;
    @FindBy(xpath = "//*[text()='See All']")
    WebElement faqs;

    public void clickOnGetARecommendation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);
        Reusable_Methods_Loggers_Page_Object.click(driver,getRecommendation,"Get a Recommendation",logger);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.close();
    }
    public void clickFindADr() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver,findADoctor,"Find A Doctor",logger);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //driver.switchTo().window(tabs.get(0));
        //driver.close();
    }
    public void clickContactUs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver,contactUs,"Contact Us",logger);
        Thread.sleep(4000);
        Reusable_Methods_Loggers_Page_Object.captureResult(driver,contactInfo,logger,"Contact Information");
    }
    public void clickOnFormsAndDocs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver,formsAndDocuments,"Forms and Documents",logger);
        Thread.sleep(2000);

    }
    public void clickOnRenewPlan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.click(driver,renewPlan,"Renew Plan",logger);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void clickOnMorePlanInfo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.scroll(driver,0,800);
        Reusable_Methods_Loggers_Page_Object.click(driver,morePlanInfo,"More Plan Info",logger);
        //Reusable_Methods_Loggers_Page_Object.captureResult(driver,costsAndBenefits,logger,"Costs & Benefits");
        //driver.close();
    }
    public void clickOnFaqs() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Medicaid Managed Care Plans page");
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.scroll(driver,0,1000);
        Thread.sleep(1500);
        Reusable_Methods_Loggers_Page_Object.click(driver,faqs,"FAQs",logger);
        driver.navigate().back();
        driver.close();
    }



}