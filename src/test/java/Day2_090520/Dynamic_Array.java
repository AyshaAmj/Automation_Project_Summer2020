package Day2_090520;

public class Dynamic_Array {
    public static void main(String[] args) {


        //dynamic array example with String data
        String[] zipCode = new String[5]; //defining and setting boundary for array values
        zipCode[0] = "11218";
        zipCode[1] = "11219";
        zipCode[2] = "10001";
        zipCode[3] = "11201";
        zipCode[4] = "11217";
        System.out.println("My last zip code is " + zipCode[4]);

        //dynamic array example with int data
        int[] checkAmount = new int[5];
        checkAmount[0] = 1000;
        checkAmount[1] = 2000;
        checkAmount[2] = 3000;
        checkAmount[3] = 4000;
        checkAmount[4] = 5000;

        System.out.println("My last check amount is " + checkAmount[4]);


    }

}
