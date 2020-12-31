package Page_Object_Test_Cases;
import Page_Object_Framework.Google_POM.Base_Class;
import Reusable_Library.Abstract_Class;
import org.testng.annotations.Test;

public class TC_Health_First extends Abstract_Class {

    @Test(priority = 1)
    public void Hfirst_Home() throws InterruptedException {

        driver.navigate().to("https://www.healthfirst.org");
        Thread.sleep(2000);
        Base_Class.hfirst_home().clickOnMedicaidManagedCare();
    }

    @Test(priority = 2)
    public void Hfirst_Medicaid_Managed_Care() throws InterruptedException {
        driver.navigate().to("https://healthfirst.org/medicaid-managed-care-plan#2020");
        Thread.sleep(2000);
        Base_Class.hfirst_medicaid_managed_care().clickOnGetARecommendation();
        Base_Class.hfirst_medicaid_managed_care().clickFindADr();
        Base_Class.hfirst_medicaid_managed_care().clickContactUs();
        Base_Class.hfirst_medicaid_managed_care().clickOnFormsAndDocs();
        Base_Class.hfirst_medicaid_managed_care().clickOnRenewPlan();
        Base_Class.hfirst_medicaid_managed_care().clickOnMorePlanInfo();
        Base_Class.hfirst_medicaid_managed_care().clickOnFaqs();
    }

    @Test(priority = 3)
    public void Hfirst_Essential_Plans() throws InterruptedException {
        driver.navigate().to("https://healthfirst.org/essential-plans/#2021");
        Thread.sleep(2000);
        Base_Class.hfirst_essential_plans().clickOnGetRecommendationEP();
        Base_Class.hfirst_essential_plans().clickFindDrEP();
        Base_Class.hfirst_essential_plans().clickOnFormsAndDocsEP();
        Base_Class.hfirst_essential_plans().clickOnRenewEssentialPlan();
        Base_Class.hfirst_essential_plans().clickOnMorePlanInfo();
        Base_Class.hfirst_essential_plans().clickOnFaqEP();
    }

    @Test(priority = 4)
    public void Hfirst_Childhealth_Plus() throws InterruptedException {
        driver.navigate().to("https://healthfirst.org/child-health-plus-plan#2020");
        Thread.sleep(2000);
        Base_Class.hfirst_childhealth_plus().clickOnchpGetRecommendation();
        Base_Class.hfirst_childhealth_plus().clickOnchpFindADr();
        Base_Class.hfirst_childhealth_plus().clickOnChpFormsAndDocs();
        Base_Class.hfirst_childhealth_plus().clickOnContactUs();
        Base_Class.hfirst_childhealth_plus().clickOnRenewChpPlan();
    }


}
