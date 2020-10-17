package actionItem;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ReusableMethodAI {
    public static void main(String[] args) throws InterruptedException {
        {
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

            System.out.println("navigating to ww website");
            driver.navigate().to("https://www.uhc.com");
            //driver.manage().window().maximize();(for Mac users)
            //delay 2 seconds
            Thread.sleep(2000);

            //capture the homepage title and verify it contains the expected title
            //which is "Health insurance Plans"
            String actualTitle = driver.getTitle();
            //verify it matches the expected title
            if (actualTitle.contains("Health insurance plans")) {
            System.out.println("Title matches");
        }else{
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }//end of conditional statement

            ArrayList<String> firstName = new ArrayList<>();
            firstName.add("Aysha");
            firstName.add("Nida");
            firstName.add("Bina");

            ArrayList<String> lastName = new ArrayList<>();
            lastName.add("Amjad");
            lastName.add("Akram");
            lastName.add("Affandi");

            ArrayList<String> dateOfBirth = new ArrayList<>();
            dateOfBirth.add("09/17/1990");
            dateOfBirth.add("04/01/1994");
            dateOfBirth.add("03/02/1965");

            ArrayList<String> ssn = new ArrayList<>();
            ssn.add("967689");
            ssn.add("365476");
            ssn.add("213425");

            ArrayList<String> zipCode = new ArrayList<>();
            zipCode.add("11204");
            zipCode.add("11214");
            zipCode.add("11218");

            for (int i = 0; i < 3 ; i++) {

                //click on find a Dr
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@aria-label='Find a Doctor']", "Find a Doctor");
                //click on Find a provider
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@id= 'btn-sign-in']", "Sign In to Find a Provider");

                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to second tab
                driver.switchTo().window(tabs.get(1));
                //click Register now
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@id='registerbutton']", "Register Now");
                //type first name
                Reusable_Methods.sendKeys(driver, "//*[@id='piFirstName']", firstName.get(i), "First Name");
                //type last name
                Reusable_Methods.sendKeys(driver, "//*[@id='piLastName']", lastName.get(i), "Last Name");
                //Date of Birth
                Reusable_Methods.sendKeys(driver, "//*[@placeholder='MM/DD/YYYY']", dateOfBirth.get(i), "Date of Birth");
                //CLick "No"
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@value='N']", "Click No");
                //SSN #
                Reusable_Methods.sendKeys(driver, "//*[@placeholder='XX-XXXX']", ssn.get(i), "SSN");
                //Enter zipcode
                Reusable_Methods.sendKeys(driver, "//*[@name='zip']", zipCode.get(i), "ZipCode");
                //Click Continue
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[text()='Continue']", "Click Continue");
                //Capture Error message
                Reusable_Methods.captureText(driver,"//*[text()='HSID server failed to respond']", "Error Message displayed");

                driver.close();//to close the new tab
                //switch back to previous tab
                driver.switchTo().window(tabs.get(0));
                //re-navigate back to uhc
                driver.navigate().to("https://www.uhc.com");

            }//end of for loop
            driver.quit();//quit browser

        }
    }//end of method
}//end of java class


