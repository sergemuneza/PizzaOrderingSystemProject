/*
>> Name: Serge MUNEZA
>> Class: Pizza
>> Description: This class models a pizza with attributes for the number of slices, a choice of meat, and a choice of vegetables.
>> Instance variables:
    - numSlices: The number of slices in the pizza.
    - meatChoice: The meat topping selected for the pizza, represented using an enum (MeatChoice).
    - vegChoice: The vegetable topping selected for the pizza, represented using an enum (VegChoice).
>> Methods:
    - Getters and Setters for all instance variables.
    - Constructor with no parameter (Default): Randomly generates values for the pizza attributes.
    - Constructor with parameter: Allows for specifying the pizza attributes directly.
    - toString: Provides a string representation of the pizza.
 */

import java.util.Random;

public class Pizza {
    private int numSlices;
    private MeatChoice meatChoice;
    private VegChoice vegChoice;

    // Enums for meat and vegetable choices
    public enum MeatChoice {
        BEEF, CHICKEN, PORK
    }

    public enum VegChoice {
        BROCCOLI, POTATOES, MUSHROOMS, ONIONS, CORN
    }

    // Getters
    public int getNumSlices() {
        return numSlices;
    }

    public MeatChoice getMeatChoice() {
        return meatChoice;
    }

    public VegChoice getVegChoice() {
        return vegChoice;
    }

//Setters
    public void setNumSlices(int numSlices) {
        this.numSlices = numSlices;
    }

    public void setMeatChoice(MeatChoice meatChoice) {
        this.meatChoice = meatChoice;
    }

    public void setVegChoice(VegChoice vegChoice) {
        this.vegChoice = vegChoice;
    }

    // With no parameter Constructor(Default)
    public Pizza() {
        Random rand = new Random();
        this.numSlices = rand.nextInt(8) + 1; // Random slices between 1 and 8
        this.meatChoice = MeatChoice.values()[rand.nextInt(MeatChoice.values().length)];
        this.vegChoice = VegChoice.values()[rand.nextInt(VegChoice.values().length)];
    }

    // With Parameter Constructor
    public Pizza(int numSlices, MeatChoice meatChoice, VegChoice vegChoice) {
        this.numSlices = numSlices;
        this.meatChoice = meatChoice;
        this.vegChoice = vegChoice;
    }


    @Override
    public String toString() {
        return " number of Slices=" + numSlices + ", meat=" + meatChoice + ", vegetables=" + vegChoice + '.';
    }
}
