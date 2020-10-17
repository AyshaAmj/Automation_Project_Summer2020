package actionItem;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Kayak_TestNG_AI {
    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Kayak_A.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Kayak_A_Results.xls"), readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite

    @Test
    public void getTotalDue() throws InterruptedException {

        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String airPort = writableSheet.getCell(0, i).getContents();
            String startDate = writableSheet.getCell(1, i).getContents();
            String startTime = writableSheet.getCell(2, i).getContents();
            String endDate = writableSheet.getCell(3, i).getContents();
            String endTime = writableSheet.getCell(4, i).getContents();
            String vehicleSize = writableSheet.getCell(5, i).getContents();

            driver.navigate().to("https://www.Kayak.com");
            Thread.sleep(2000);
            String actualTitle = driver.getTitle();
            //verify it matches the expected title
            if (actualTitle.contains("KAYAK")) {
                System.out.println("Title matches");
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }
            //below code is inspected before you clicking inside the search field
            //and I am using contains id property as initial portion of id value
            //is changing
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[contains(@id,'pickup-display')]", "Pick up Location");
            Thread.sleep(2000);
            Reusable_Methods.sendKeys(driver, "//*[@name='pickup']",airPort,"Airport");
            Thread.sleep(4000);
            //you forgot to click on suggesting link once you type your airport so it is blocking
            //start date calendar
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@class='smarty-item-icon']", "Choose Airport Link");
            //now put like 1 to 2 seconds then click on start date calendar icon
            Thread.sleep(4000);
            //line below you were missing @ symbol before id and  closing xpath bracket ]
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[contains(@id,'dateRangeInput-display-start-inner')]","Start Date");
            Reusable_Methods.userKeysByIndex(driver,"//*[contains(@id,'pickup-date-input')]" ,startDate, 0 ,"10/20/2020");

            //element below is not intractable because you have to close the calendar so click anywhere outside
            //like clicking on title search for hundred
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@class='title dark']","Dark Title");
            Thread.sleep(1000);
            //Actions actions = new Actions(driver);
            //actions.moveToElement(startTime).click().perform();
            //before you select the value from start time you need to click on start time first
            Reusable_Methods.mouseClick(driver, "//*[contains(@id,'start-time-select-display')]","Start Time");
            Thread.sleep(2000);
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[contains(@class,'date-input-inner-text _iVh') and @data-placeholder='Drop-off']","End Date");
            Reusable_Methods.userKeysByIndex(driver,"//*[contains(@id,'pickup-date-input')]" ,endDate, 1 ,"10/25/2020");
            //Reusable_Methods.click(driver,"//*[@class='title dark']","Dark Title");
            Thread.sleep(1000);
            Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@class='icon ']", "Click Search");
            Reusable_Methods.clickByIndex(driver, "//*[text()='Small']",1, "Choosing size");
            Reusable_Methods.clickByIndex(driver,"//*[text()='View Deal']",2,"Click on 3rd car");


            //now click on start time value
            //Reusable_Methods.click(driver, "//*[contains(@id,'start-time-select-option') and @data-title='10:00 am']","Start Time Value");
            //Reusable_Methods.clickByJS(driver, "//*[contains(text()='1:00 am')]", "start time");


//now do the same for calendar end date by choosing accurate property
//after entering end date you can click outside to close the calendar
//then same click end time first
//wait few seconds then click on end time value
            /*Reusable_Methods.click(driver, "//*[@aria-invalid='true']", "Click Pick up");
            Reusable_Methods.click(driver, "//*[@name='pickup']", "Pick up Location");
            Reusable_Methods.sendKeys(driver, "//*[@name='pickup']",airPort,"Airport");
            Reusable_Methods.click(driver,"//*[contains(id,'dateRangeInput-display-start-inner')","Start Date");
            Reusable_Methods.typeAndSubmit(driver,"//*[contains(@id,'pickup-date-input')]","10/20/2020","10/20/2020");
            Reusable_Methods.click(driver, "//*[@aria-label='Calendar icon']", "Start Date");
            Reusable_Methods.sendKeys(driver, "//*[contains(class,'Common-Widgets-Datepicker-StyleJamDateTimeInput-DateTimeInput')]","10/20/20","Start Date");
            Reusable_Methods.click(driver, "//*[contains(@id,'start-time-select-option') and @data-title='" +endTime+"']","Start Time");*/

        }
    }
}
