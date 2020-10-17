package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class mlcalc_with_for_loop {
    public static void main(String[] args) throws InterruptedException {

        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

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

        //set the values for purchase price array list
        ArrayList<String>pPriceList = new ArrayList<>();
        pPriceList.add("350000");
        pPriceList.add("400000");

        //set the values for down payment array list
        ArrayList<String>dPaymentList = new ArrayList<>();
        dPaymentList.add("30");
        dPaymentList.add("50");

        //call the for loop to iterate through the array list
        for (int i = 0; i < pPriceList.size(); i++){
            //navigate to mlcalc page
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);

            //clear and enter purchase price
            try {
                System.out.println("Entering new value on Purchase Price");
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            }catch (Exception err){
                System.out.println("Unable to enter value on Purchase Price" + err);
            }//end of purchase price exception

            //clear and enter down payment
            try {
                System.out.println("Entering new value on Down Payment");
                WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentList.get(i));
            }catch (Exception err) {
                System.out.println("Unable to enter value on down payment" + err);
            }//end of down payment exception

            //clicking on Calculate button
            try {
                System.out.println("Clicking on Calculate button");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
            }catch (Exception err) {
                System.out.println("Unable to click on Calculate button " + err);
            }//end of Calculate button exception

            Thread.sleep(2500);
            //capture and print monthly payment
            try {
                System.out.println("Capturing monthly payment");
                String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("My monthly payment is " + mntPayment);
            }catch (Exception err) {
                System.out.println("Unable to click on Calculate button " + err);
            }//end of Calculate button exception

            //capture and print monthly payment
            //try {
            //     System.out.println("Capturing monthly payment");
            //     String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
            // } catch (Exception err) {
            //     System.out.println("Unable to click on Calculate button " + err);
            // }//end of Calculate button exception


        }//end of for loop

    }//end of class

}//end of main method
