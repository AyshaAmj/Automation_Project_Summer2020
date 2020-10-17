package actionItem;


import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayakk_AI {
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
        public void getTotalDue() throws InterruptedException, WriteException {

            //all the test steps have to go inside for loop
            for (int i = 1; i < rowCount; i++) {
                //need to get the content of the cell
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
                //pick up location
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[contains(@id,'pickup-display')]", "Pick up Location");
                Thread.sleep(2000);
                //Data Airport
                Reusable_Methods.sendKeys(driver, "//*[@name='pickup']", airPort, "Airport");
                Thread.sleep(4000);
                //clicking on desired link
                Reusable_Methods.mouseClick(driver,"//*[contains(@id, 'pickup-display-inner')]","Click Airport link" );
                //start date calendar
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@class='smarty-item-icon']", "Choose Airport Link");
                Thread.sleep(4000);
                //Start time value
                Reusable_Methods.mouseClick(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+startTime+"']", "Start time value");
                //Enter end date
                Thread.sleep(1000);
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[contains(@id, 'dateRangeInput-display-end-inner')]", "End date");
                Thread.sleep(2000);
                //enter and submit end date
                Reusable_Methods.typeAndSubmit(driver,"contains(@id,'dropoff-date-input')]",endDate,"Enter Date");
                Reusable_Methods.click(driver, "//[@class='creditCardNumber']", "//*[@class='title dark']","Dark Title");
                Thread.sleep(1000);
                //click on end time
                Reusable_Methods.mouseClick(driver,"//*[contains(@id,'dateRangeInput-end-time-select-display-status')]","End Time");
                Thread.sleep(2000);
                //Enter end time
                Reusable_Methods.mouseClick(driver, "//*[contains(@id, 'end-time-select-option') and @data-title='"+endTime+"']", "Enter Time");
                Thread.sleep(1500);
                //click on search button
                Reusable_Methods.mouseClick(driver,"//*[contains(@id,'submit')]","Search");
                //Choose car size
                Reusable_Methods.clickByIndex(driver, "//*[text()='Small']",1, "Choosing size");
                //Click on first car
                Reusable_Methods.clickByIndex(driver,"//*[contains(@class,'_iac _ikn _h-2 _iab _iaB _id7 _ia1 _iAr _iiZ _idj _ii0 _iir _inw')]",0,"Clicking on first car");
                //click on 'View Deal'
                Reusable_Methods.mouseClick(driver, "//*[@class='o3Q9-button-content']", "View deal");
                //Switch tabs
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String result = Reusable_Methods.captureText(driver,"//*[@class='fpiCell']","Total Amount");
                System.out.println("My Total amount is " + result);
                Label label = new Label(6, i, result);
                //adding this label to the writable sheet
                writableSheet.addCell(label);
                driver.close();//to close the new tab
                //switch back to previous tab
                driver.switchTo().window(tabs.get(0));
                //re-navigate back to Kayak
                driver.navigate().to("https://www.kayak.com");












            }
            driver.quit();
        }
}
