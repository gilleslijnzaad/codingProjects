package com.company;
import java.util.*;

public class Day {
    private static int dayNumber;
    private String weather;
    private Main m;

    /**
     * Constructor
     * @param dayNumber     Indicates what day it is; is displayed to the user when the day starts
     * @param weather       Indicates the weather; is displayed to the user when the day starts. Options are sunny,
     *                      cloudy and rainy. If it rains, crops grow faster.
     */

    public Day(int dayNumber, String weather) {
        this.dayNumber = dayNumber;
        this.weather = weather;
    }

    private String generateWeather() {
        Random r = new Random();
        int weatherNumber = r.nextInt(4);
        if (weatherNumber == 1 || weatherNumber == 2) {
            return "sunny";
        } else if (weatherNumber == 3) {
            return "cloudy";
        } else {
            return "rainy";
        }
    }

    public void beginDay() {
        weather = generateWeather();
        dayNumber = this.getDayNumber() + 1;
        System.out.println("...");
        m.pause(2000);
        System.out.println("Day " + dayNumber + ": it's " + weather + " today.");
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
