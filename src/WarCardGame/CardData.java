package WarCardGame;

/* Daniel Son
 * January 22, 2016
 * Purpose: This class will be used as objects that hold the card characteristics: value, suit
 * Output: N/A
 */

/**
 * The class CardData is utilized as a data storage. The main purpose for this class is to be created as
 * an object which stores a card value like its value and suit.
 */
public class CardData {
    //global variables
    private int value;
    private String suit;

    /**
     * The constructor CardData stores the data information into the global variables
     * @param value The value of the card
     * @param suit The suit of the card
     */
    public CardData(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * The method getValue will return the value of the card
     * @return A integer value of the cards value
     */
    public int getValue(){
        return this.value;
    }

    /**
     * The method getSuit will return the suit of the card
     * @return A String value of the cards suit
     */
    public String getSuit(){
        return this.suit;
    }


}
