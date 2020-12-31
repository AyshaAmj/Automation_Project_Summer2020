package Page_Object_Framework.Google_POM;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers;
import Reusable_Library.Reusable_Methods_Loggers_Page_Object;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hfirst_Home extends Abstract_Class {
    ExtentTest logger;

    public Hfirst_Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor method

    @FindBy(xpath = "//*[text()='Plans ']")
    WebElement plans;
    @FindBy(xpath = "//*[text()='Individual & Family']")
    WebElement individualFamily;
    @FindBy(xpath = "//*[text()='Medicaid Managed Care']")
    WebElement medicaidManagedCare;

    public void clickOnMedicaidManagedCare() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        logger.log(LogStatus.INFO,"Navigating to Health First Home page");
        driver.navigate().to("https://healthfirst.org");
        Thread.sleep(3000);

        Reusable_Methods_Loggers_Page_Object.mouseHover(driver,plans,"Plans",logger);
        Reusable_Methods_Loggers_Page_Object.mouseHover(driver, individualFamily, "Individual & Family Plans", logger);
        Reusable_Methods_Loggers_Page_Object.click(driver, medicaidManagedCare, "Medicaid Managed Care", logger);

    }//end of click on medicaid managed care method



}

