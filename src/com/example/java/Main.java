package com.example.java;
import java.util.Scanner;

//Create 2 dimensional array that will hold name and quantities
//ask user to add/subtract if desired, display math and loop until user exits.
public class Main {

    public static void main(String[] args) {
        int userNum, userOption,addAmount, subAmount, tempQuantity, finalQuantity;

        Scanner input = new Scanner(System.in);

	// program will create an array of strings for office supplies. String.valueOf used to create  integers in array
        String[][] supplies = new String[6][2];
        supplies[0][0] = "Paper";
        supplies[0][1] = String.valueOf(500);
        supplies[1][0] = "Pens";
        supplies[1][1] = String.valueOf(50);
        supplies[2][0] = "Pencils";
        supplies[2][1] = String.valueOf(45);
        supplies[3][0] = "Staplers";
        supplies[3][1] = String.valueOf(5);
        supplies[4][0] = "Notepads";
        supplies[4][1] = String.valueOf(12);
        supplies[5][0] = "Staples";
        supplies[5][1] = String.valueOf(250);

        System.out.println("Office Supplies Inventory:");
        System.out.println("");

   //main do-while loop for entire program, user may exit after displaying quantities
        do{
    //sub do-while loop that asks the user to select an item, loop verifies correct number chosen
            do {
                System.out.println("");
                for (int i = 0; i < supplies.length; i++) {
                    System.out.println(i + "." + supplies[i][0]); //for loop to display options to user from array
                }
                System.out.println("");
                System.out.println("Which item quantity would you like displayed?");
                userNum = input.nextInt();
    //if searched item matches item in array, contents will be displayed
                if (userNum >= 0 && userNum <= 5) {
                    System.out.println(supplies[userNum][0] + ": " + supplies[userNum][1]);
                }
                else System.out.println("Invalid Number");
            }while (userNum < 0 || userNum > 5);
    //sub do-while loop for adding/subtracting or exiting program. input verification for wrong input.
            do {
                System.out.println("");
                System.out.println("What would you like to do?");
                System.out.println("1. Add Inventory");
                System.out.println("2. Subtract Inventory");
                System.out.println("3. Display another Item");
                System.out.println("4. Exit");

                userOption = input.nextInt();

                switch (userOption) {
                    case 1:         //adds a user specific quantity to current item
                        System.out.println("Enter amount you want to add.");
                        addAmount = input.nextInt();

                        tempQuantity = Integer.parseInt(supplies[userNum][1]);
                        finalQuantity = tempQuantity + addAmount;
                        supplies[userNum][1] = String.valueOf(tempQuantity + addAmount);
                        System.out.println("");
                        System.out.println(supplies[userNum][0] + ": " + tempQuantity + " + " + addAmount + " = " + finalQuantity);

                        break;
                    case 2:         //add a user specific quantity to current item, if less than 0, 0 will be set for item
                        System.out.println("Enter amount you want to subtract.");
                        subAmount = input.nextInt();

                        tempQuantity = Integer.parseInt(supplies[userNum][1]);
                        finalQuantity = tempQuantity - subAmount;
                        supplies[userNum][1] = String.valueOf(tempQuantity - subAmount);
                        //lets the user know the items totaled less than 0
                        if (finalQuantity < 0) {
                            supplies[userNum][1] = String.valueOf(0);
                            finalQuantity = 0;
                            System.out.println("Quanity is less than 0");
                        }

                        System.out.println("");
                        System.out.println(supplies[userNum][0] + ": " + tempQuantity + " - " + subAmount + " = " + finalQuantity);
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Now exiting...");   //exits program and loop
                        break;

                    default:
                        System.out.println("Invalid Entry!");
                }
            }while (userOption < 1 || userOption >4);

        }while(userOption != 4);
    }
}
