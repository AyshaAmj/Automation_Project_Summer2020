package Day11_10042020;

import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestNG_MortgageCalc {

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
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Mortgage_Info.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_Info_Results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite

    @Test
    public void getMonthlyPayment() throws WriteException, InterruptedException {
        //all the test steps have to go inside for loop
        for(int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String homeVal = writableSheet.getCell(0, i).getContents();
            String downPay = writableSheet.getCell(1, i).getContents();
            String loanAmount = writableSheet.getCell(2, i).getContents();
            String startMonth = writableSheet.getCell(3, i).getContents();
            String startYear = writableSheet.getCell(4, i).getContents();

            //navigate to mortgage home
            driver.navigate().to("https://www.mortgagecalculator.org");
            Thread.sleep(2000);
            //enter home value
            Reusable_Methods.sendKeys(driver, "//*[@id='homeval']", homeVal, "Home Value");
            //enter down payment
            Reusable_Methods.sendKeys(driver, "//*[@id='downpayment']", downPay, "Down Payment");
            //enter the loan amount
            Reusable_Methods.sendKeys(driver, "//*[@id='loanamt']", loanAmount, "Loan Amount");
            //select the month
            Reusable_Methods.dropDownByVisibleText(driver, "//*[@name='param[start_month]']", startMonth, "Start Month");
            //enter start year
            Reusable_Methods.sendKeys(driver, "//*[@id='start_year']", startYear, "Start Year");
            //click on Calculate button
            //Reusable_Methods_Loggers.click(driver, "//[@class='creditCardNumber']", "//*[@value='Calculate']", "Calculate");
            Thread.sleep(2000);
            //capture the monthly payment
            String result = Reusable_Methods.captureText(driver, "//*[@class='left-cell']/following::h3[contains(text(),'$')]", "Monthly Payment");
            System.out.println("My monthly payment is " + result);

            //store and send it to the empty column in excel writable file
            Label label = new Label(5, i, result);
            //adding this label to the writable sheet
            writableSheet.addCell(label);
        }//end of for loop
    }//end of test

    @AfterSuite
    public void closingInfo() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite



}//end of java class




