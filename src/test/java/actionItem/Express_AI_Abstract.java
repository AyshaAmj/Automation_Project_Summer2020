package actionItem;
import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

    public class Express_AI_Abstract extends Abstract_Class{
        //declare all the global variables outside
        Workbook readableFile;
        Sheet readableSheet;
        WritableWorkbook writableFile;
        WritableSheet writableSheet;
        int rowCount;

        @Test
        public void Express_Shop() throws InterruptedException, IOException, BiffException, WriteException {
            //Step 1: locate the readable excel workbook
            readableFile = Workbook.getWorkbook(new File("src/main/resources/ExpressAI_1.xls"));
            //Step 2: locate the excel sheet for this readable workbook
            readableSheet = readableFile.getSheet(0);
            //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
            writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressAI_2_Results.xls"), readableFile);
            //Step 4: define the writable sheet for writable file
            writableSheet = writableFile.getSheet(0);
            //Ste 5: get the count of the rows that are not empty on your excel workbook
            rowCount = writableSheet.getRows();


            //all the test steps have to go inside for loop
           for (int i = 1; i < rowCount; i++) {
                //I need to get the content of the cell
                //column is hard coded and row is dynamic(i)
                String size = writableSheet.getCell(0, i).getContents();
                String quantity = writableSheet.getCell(1, i).getContents();
                String firstName = writableSheet.getCell(2, i).getContents();
                String lastName = writableSheet.getCell(3, i).getContents();
                String emailAddress = writableSheet.getCell(4, i).getContents();
                String phoneNumber = writableSheet.getCell(5, i).getContents();
                String address = writableSheet.getCell(6, i).getContents();
                String zipCode = writableSheet.getCell(7, i).getContents();
                String city = writableSheet.getCell(8, i).getContents();
                String state = writableSheet.getCell(9, i).getContents();
                String cardNumber = writableSheet.getCell(10, i).getContents();
                String expMonth = writableSheet.getCell(11,i).getContents();
                String expYear = writableSheet.getCell(12,i).getContents();
                String cvv = writableSheet.getCell(13,i).getContents();

                driver.manage().deleteAllCookies();
                logger.log(LogStatus.INFO, "Navigating to www.Express.com");
                Thread.sleep(2000);
                driver.navigate().to("https://www.express.com");
                Thread.sleep(2000);
                String actualTitle = driver.getTitle();
                //verify it matches the expected title
                if (actualTitle.contains("Men's and Women's Clothing")) {
                    System.out.println("Title matches");
                } else {
                 System.out.println("Title doesn't match. Actual title is " + actualTitle);
                }

                Thread.sleep(3000);
                //Actions actions = new Actions(driver);
                Reusable_Methods_Loggers.mouseHoverIndex(driver,"//*[@class= 'MegaMenu_primaryNav__3G5fm']",1,"Men's Clothing");
                Thread.sleep(2500);
                Reusable_Methods_Loggers.click(driver,"//*[text()='Shirts']","Clicking on Shirts", logger);
                Thread.sleep(3000);
                Reusable_Methods_Loggers.scroll(driver,0,400);
                Thread.sleep(2000);
                Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='L_d7U']", 2,"Plaid shirt");
               Thread.sleep(4000);
               Reusable_Methods_Loggers.mouseHover(driver,"//*[@class='_2PJe9 labelActive']","Click Title");
               Thread.sleep(2000);
               Reusable_Methods_Loggers.scroll(driver,0,300);
               Reusable_Methods_Loggers.click(driver,"//*[@value='"+size+"']","Choose size", logger);
               Thread.sleep(3000);
               Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']","Add to bag", logger);
               Thread.sleep(2000);
               Reusable_Methods_Loggers.click(driver,"//*[text()='View Bag']","View Bag", logger);
               Thread.sleep(2000);
               Reusable_Methods_Loggers.click(driver,"//*[@class='g-x-icon']","Click on X",logger);
               Thread.sleep(1000);
               Reusable_Methods_Loggers.scroll(driver,0,400);
               Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='qdd-0-quantity']",logger,"Quantity");
               Reusable_Methods_Loggers.clickByJS(driver,"//*[@value='"+quantity+"']",logger,"Choosing Quantity");
               Thread.sleep(1000);
               Reusable_Methods_Loggers.click(driver,"//*[text()='Checkout']","Check Out", logger);
               Thread.sleep(2000);
               Reusable_Methods_Loggers.click(driver,"//*[text()='Checkout as Guest']","Check out as guest", logger);
               Thread.sleep(2000);
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"First Name");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='lastname']", lastName,logger,"Last Name");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='email']", emailAddress,logger,"Typing Email");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='confirmEmail']",emailAddress,logger,"Confirm Email");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger,"Phone Number");
               Reusable_Methods_Loggers.click(driver,"//*[text()='Continue']","Continue", logger);
               Thread.sleep(1000);
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger,"Shipping address");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"Zipcode");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"City");
               Reusable_Methods_Loggers.scroll(driver,0,400);
               Reusable_Methods_Loggers.dropDownByIndex(driver,"//*[@name='shipping.state']",logger,33,"NY" );
               Reusable_Methods_Loggers.scroll(driver,0,600);
               Reusable_Methods_Loggers.click(driver,"//*[text()='Continue']","Continue",logger);
               //Reusable_Methods_Loggers.mouseClick(driver, "//[@id='creditCardNumberInput']", logger ,"Clicking on Card number field");
               Thread.sleep(2500);
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='creditCardNumberInput']",cardNumber,logger,"Card Number");
               Reusable_Methods_Loggers.scroll(driver,0,300);
               Reusable_Methods_Loggers.dropDownByIndex(driver,"//*[@name='expMonth']",logger,2,"Exp Month");
               Reusable_Methods_Loggers.dropDownByIndex(driver,"//*[@name='expYear']",logger,1,"Exp Year");
               Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='cvv']",cvv,logger,"Cvv");
               Reusable_Methods_Loggers.clickByJS(driver,"//*[text()='Continue']",logger,"Continue");
               Reusable_Methods_Loggers.click(driver,"//*[text()='Place Order']","Place Order", logger);
                Thread.sleep(5000);
               String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='xnY7x notification']",logger,"Error Message");
               System.out.println("My Error Message is " + result);
               Label label = new Label(14, i, result);
               //adding this label to the writable sheet
               writableSheet.addCell(label);
               driver.navigate().to("https://www.express.com");


           }
           driver.quit();

        
   }}
