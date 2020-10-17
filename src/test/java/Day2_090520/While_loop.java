package Day2_090520;

public class While_loop {

    public static void main(String[] args) {

        String[] zipCode = new String[6]; //defining and setting boundary for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";
        zipCode[5] = "11223";

        //first initialize the starting point before while loop
        int i = 0;
        //Define the while loop with your end point execution
        while(i < zipCode.length){

            System.out.println("My zipcode is " + zipCode[i]);
            //increment goes here
            i = i + 1; //same as i++
        }//end of while loop

    }//end of main method
    
}//end of class
