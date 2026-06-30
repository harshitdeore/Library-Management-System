package util;

import java.util.Scanner;

public class InputValidator {

    public static int readPositiveInt(Scanner sc, String message){
        int value;

        while (true){
            System.out.println(message);
            value = sc.nextInt();

            if (value > 0){
                return value;
            }else {
                System.out.println("Enter a positive number.");
            }
        }
    }

    public static String readNonEmptyString(Scanner sc, String message){
        String value;

        while (true){
            System.out.println(message);
            value = sc.nextLine();

            if (!value.trim().isEmpty()){
                return value;
            }else {
                System.out.println("Input cannot be empty.");
            }
        }
    }

    public static double readPositiveDouble(Scanner sc, String message){
        double value;

        while (true){
            System.out.println(message);
            value = sc.nextDouble();

            if (value >=0){
                return value;
            }else {
                System.out.println("Price cannot be negative.");
            }
        }
    }

    public static boolean readIssuedStatus(Scanner sc, String message){
        boolean value;

        while (true){
            System.out.println(message);
            value = sc.hasNextBoolean();

            if (value){
                return sc.nextBoolean();
            }

            System.out.println("Please enter only true or false.");
            sc.next();
        }
    }
}
