package Day1_08302020;

import java.util.Scanner;

public class Strings3 {
    public static void main(String[] args) {
         // First way of printing your variable
        //First give your string/integer a variable
        String first_name;
        String last_name;
        String Address;
        int Zipcode;
        String city;
        String State;

        //Giving your variable a value
        first_name = "John";
        last_name = "Doe";
        Address = "1122 main Street";
        Zipcode = 11224;
        city = "Brooklyn";
        State = "New york";
            System.out.println("My First name is " + first_name + " My last name is " + last_name +
                    " My Address is " + Address +  " My Zipcode is " + Zipcode + " My city is " + city + " and My State is " + State);


            //Second way of writing/declaring string
            //Give your string/integer a variable
            //Then give your variable/integer a value on the same line
        String firstName = "Jane";
        String lastName = "Doe";
        String address = "1321 Main Blvd";
        int zipCode = 11235;
        String City = "Bronx";
        String state = "New York";

            System.out.println("My First Name is " + firstName + " My last name is " + lastName +
                " My Address is " + address +  " My Zipcode is " + zipCode + " My city is " + City + " and My State is " + state);


            //Third way is getting information from user and printing the statement
        Scanner scan = new Scanner(System.in);

            System.out.println("what's your name ");
        String name = scan.next();

            System.out.println(" what's your age ");
        int age = scan.nextInt();

            System.out.println(" what is your phone number ");
        Long phone = scan.nextLong();

            System.out.println(" what is your gender");
        char Gender = scan.next().charAt(0);

            System.out.println(" what's your favorite inspiration quote ");
        String quote = scan.next();
        quote = quote + scan.nextLine();

            System.out.println(" Do you smoke ");
        String smoker = scan.next();


            System.out.println("my name is " + name +
                " my age is " + age +
                " my phone number is " + phone +
                " my gender is " + Gender +
                " and my favorite quote is " + quote);

        if (smoker == "yes"){
            System.out.println("you need to stop smoking");
        }else if( smoker != "no"){
            System.out.println("That's great, stay away from smoking ");
        }
    }//end of main Method
}//end of Class



