package actionItem;

import java.util.concurrent.LinkedTransferQueue;

public class String_Practice {

    public static void main(String[] args) {
        String[] Cities = new String[4];

        Cities[0] = "Brooklyn";
        Cities[1] = "Queens";
        Cities[2] = "Manhattan";
        Cities[3] = "Staten Island";



       for(int i = 0; i < Cities.length; i++) {

           if(Cities[i] == "Brooklyn"){
               System.out.println(Cities[i]);
           }
           if (Cities[i]== "Manhattan"){
               System.out.println(Cities[i]);
           }



        }//end of for loop


    }//end of main method

}//end of class
