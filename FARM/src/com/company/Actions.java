package com.company;
import java.lang.reflect.Array;
import java.util.*;

public class Actions {
    private final Scanner scan = new Scanner(System.in);
    public Day today;
//    final Scanner scan = new Scanner(System.in);

    public Actions(Day today) {
        this.today = today;
    }

    public void help() {
        System.out.println("Here's a list of commands and the actions that correspond to it.");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("buy       : Buy seeds; they will be put in your inventory");
        System.out.println("sow       : Sow seeds you bought; they will be put on your field");
        System.out.println("harvest   : Harvest crops (when they are ready); they will be put in your inventory");
        System.out.println("sell      : Sell crops");
        System.out.println("sleep     : End the day by going to sleep");
        System.out.println("field     : Display what's on your field");
        System.out.println("inventory : Display what's in your inventory");
        System.out.println("help      : Display what the different commands mean");
        System.out.println("end       : End the game");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void printSeedInfo(Crop crop) {

    }

    public void buy() {
        ArrayList<Crop> boughtSeeds;
        System.out.println("Here's a list of the seeds you can buy.");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Crop name\t\tBuying price\t\tSelling prince\t\tGrowing days");
        printSeedInfo(potato);
        for (Crop crop : this.crops) {
            System.out.println(crop.getName() + "\t\t\t\t" + crop.getBuyPrice() + "\t\t\t\t\t" + crop.getSellPrice()
            + "\t\t\t\t\t" + crop.getGrowingDays());
        }
        System.out.println("What crop would you like to buy seeds of? potato (p), cabbage (c) or onion (o)?");
        String input = scan.nextLine();
        switch (input) {
            case "p":
                boughtSeeds.add()
                break;
            case "c":
                break;
            case "o":
                break;
        }
        //return boughtSeeds;
    }

    public void act(String userName) {
        System.out.println("What do you want to do?");
        String input = scan.nextLine();
        switch (input) {
            case "buy":
                System.out.println("Welcome to the store, " + userName + "!");
                buy();
                break;
            case "sow":
                System.out.println("We're gonna sow stuff");
                break;
            case "harvest":
                System.out.println("We're gonna harvest shit");
                break;
            case "sell":
                System.out.println("Let's make that coin");
                break;
            case "sleep":
                System.out.println("Alright. Day " + today.getDayNumber() + " ends. Good night!");
                today.beginDay();
                act(userName);
                break;
            case "field":
                System.out.println("What's on your field?");
                break;
            case "inventory":
                System.out.println("What's in your inventory?");
                break;
            case "help":
                help();
                break;
            case "end":
                System.out.println("Thank you for playing. Goodbye!");
                System.exit(0);
            default:
                System.out.println("What you entered does not seem to be valid, please try again");
                act(userName);
                break;
        }
    }
}
