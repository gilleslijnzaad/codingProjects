package com.company;

import java.util.*;

public class Main {
    private static String userName;

    public static void pause(long milliseconds) {
        try {Thread.sleep(milliseconds);}
        catch(InterruptedException e) {}
    }

    /*
        Initializes an array of crops (hardcoded)
        @return     An array of crops
     */

    public static void pressEnterToContinue() {
        try{System.in.read();}
        catch(Exception e){}
    }

    /*
        Overloaded method pressEnterToContinue: this one takes a string as an argument to indicate that the
        "Press Enter to continue..." statement should be printed too
     */
    public static void pressEnterToContinue(String s) {
        System.out.println("Press Enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
    }

    public static void main(String[] args) {
        Day day = new Day(0, "");
        Actions action = new Actions(day);
        final Scanner scan = new Scanner(System.in);

//            System.out.println("F.A.R.M. - an interactive game by Gilles Lijnzaad\n");
//            pause(750);
//            System.out.println("Welcome, new farmer! Please enter your name.");
//            String input = scan.nextLine();
//            userName = input;
//            pause(1000);
//            System.out.println("Nice to meet you, " + userName + "! Here's an explanation of how this game works.");
//            pressEnterToContinue("");
//            System.out.println("As a farmer, you have a field that you can grow crops on. " +
//                    "In order to do that, you must first buy seeds and sow them.");
//            pressEnterToContinue();
//            System.out.println("After a number of days, your crops will be ready for harvest. This number of days is " +
//                    "different for each type of crop.");
//            pressEnterToContinue();
//            System.out.println("When you've harvested your crops you can sell them on the market to make profit.");
//            pressEnterToContinue();
//            System.out.println("Does that sound clear to you? You might need some more information on how to play...\n");
//            pause(1000);
//            action.help();
//            pressEnterToContinue();
//            System.out.println("If it's all clear, let's start your first day! Remember you can always enter the command" +
//                    " \"help\" if you've forgotten how the game works. Good luck!");
//            pressEnterToContinue();
        day.beginDay();
        action.act(userName);
    }
}
