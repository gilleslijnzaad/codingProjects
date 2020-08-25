package com.company;

abstract public class Crop {
    private int buyPrice;
    private int sellPrice;
    private int growingDays;
    private int numberSeeds;
    private int numberGrownCrops;
    private int daysTilHarvest;

    /**
     * Constructor
     * @param buyPrice      how much the farmer pays for seeds of this crop (per m2)
     * @param sellPrice     how much the farmer gets for harvested crop (per m2)
     * @param growingDays   how many days it takes for the seeds to grow into a mature crop
     */
    public Crop(int buyPrice, int sellPrice, int growingDays) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.growingDays = growingDays;
    }

    public int getBuyPrice() { return buyPrice; }

    public int getSellPrice() { return sellPrice; }

    public int getGrowingDays() { return growingDays; }
}
