package Day2_090520;

import java.sql.SQLOutput;

public class Array {

    public static void main(String[] args) {
        //linear String array example
        String[] username = new String[]{"John", "Kenneth", "Milad","Naim","2"};
        String[] lastName = new String[]{"John", "Kenneth", "Milad","Naim","2"};

        //print second value from string array
        System.out.println("second user name is " + username[1] + " last name is " + lastName[1]);

        //linear integer array example
        int[] number = new int[]{1,100,300,500};
        System.out.println("I am " + number[2] + " years old ");
        System.out.println("I ate " + number[0] + " cookie and it had " + number[3] + " calories ");

    }
}
