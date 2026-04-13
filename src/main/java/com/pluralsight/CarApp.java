package com.pluralsight;

import java.util.Scanner;

public class CarApp {
    public static void main(String[] args) {
        // Initializing Scanner and prompting customer for information
        Scanner input = new Scanner(System.in);
        System.out.println("When do you want to pick up the vehicle?: ");
        String pickUpDate = input.nextLine();
        System.out.println("How many days do you want to rent the vehicle for?: ");
        int rentalDays = input.nextInt();
        System.out.println("Do you need an electronic tag?: (Y/N) ");
        input.nextLine();
        String userReply = input.nextLine();
        boolean electronicTag = (userReply.equals("Y")) ? true : false;
        System.out.println("Do you need a GPS: (Y/N) ");
        userReply = input.nextLine();
        boolean needGPS = (userReply.equals("Y")) ? true : false;;
        System.out.println("Would you like roadside assistance?: (Y/N) ");
        userReply = input.nextLine();
        boolean roadsideAssistance = (userReply.equals("Y")) ? true : false;;
        System.out.println("How old are you?: ");
        int customerAge = input.nextInt();

        // Printing menu
        printMenu(pickUpDate,rentalDays,electronicTag,needGPS,roadsideAssistance,customerAge);
    }
    public static void printMenu(String date, int numDays, boolean tag, boolean GPS, boolean roadAssistance, int age){

        // Initialize rental rate and total price variables
        float basePrice = 29.99f;
        float totalPrice;
        System.out.println("=============================");

        // Print out base information about rental
        System.out.printf("Pick Up Date: %s \nRental Days: %d\n", date, numDays);

        // Change base price if they are under / over age and print out information
        if (age >= 25){
            System.out.printf("Base Price per day: %.2f\n", basePrice);
            totalPrice = basePrice * numDays;
        } else {
            basePrice *= 1.3f;
            System.out.printf("(Underage driver) Base Price per day: %.2f\n", basePrice);
            totalPrice = basePrice * numDays;
        }

        // Check if customer opted in for packages and if none are selected print
        System.out.println("Options chosen: ");
        if (tag){
            System.out.println("Electronic Toll Tag package: $3.95/day");
            totalPrice += 3.95f * numDays;
        }
        if (GPS){
            System.out.println("GPS package: $2.95/day");
            totalPrice += 2.95f * numDays;
        }
        if (roadAssistance){
            System.out.println("Roadside Assistance package: $3.95/day");
            totalPrice += 3.95f * numDays;
        }
        if (!tag && !GPS && !roadAssistance) {
            System.out.println("No package selected");
        }

        // Output total price and menu ending
        System.out.printf("Total price for rental: %.2f\n", totalPrice);
        System.out.println("=============================");


    }
}
