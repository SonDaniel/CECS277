package WarCardGame;

/* Daniel Son
 * January 22, 2016
 * Purpose: This program simulates the card game of War.
 * Output: The simulation of two players playing the game of War.
 */

/**
 * This method Assignment1 is the main method the program will execute to start.
 * This method calls the object Cards and uses the methods within the Cards class to execute the game of War
 */
public class Assignment1 {
    public static void main(String[] args){
        //initialize deck
        Cards card = new Cards();

        //shuffles deck three times for good measure
        card.shuffleDeck();

        //deals out half the deck to player 1 and 2
        card.dealDecks();

        //starts the game of war
        card.startGame();
    }


}
