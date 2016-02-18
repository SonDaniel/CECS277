package WarCardGame;

/* Daniel Son
 * January 22, 2016
 * Purpose: This program will create a deck of cards and have the duties of dealing with any action with cards.
 * Output: N/A
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class Cards initializes a deck of cards.
 * The class allows the program to shuffle the deck.
 * The class allows the program to deal the deck in half between two players.
 * The class has a method that displays the players hand.
 * The class has a method that determines if a card is a face card.
 * The startGame method is the main game that utilizes all the methods.
 * The startWar method is used to deal three anonymous cards to the players.
 */
public class Cards {
    //global variables set to private
    private static ArrayList<CardData> deck;
    private static ArrayList<CardData> player1Deck;
    private static ArrayList<CardData> player2Deck;
    private static ArrayList<CardData> player1Hand;
    private static ArrayList<CardData> player2Hand;
    private static int deckIndex;

    /**
     * The constructor Cards creates a deck of cards using an ArrayList
     * with the data type of CardData objects to store information.
     */
    public Cards(){
        //creating arrayList to hold suit
        ArrayList<String> suit = new ArrayList<>();
        suit.add(" of Diamonds");
        suit.add(" of Clubs");
        suit.add(" of Hearts");
        suit.add(" of Spades");

        //creating arrayList to hold value
        ArrayList<Integer> value = new ArrayList<>();
        for(int ii = 2; ii <= 14; ii++)
        {
            value.add(ii);
        }

        //counters
        int suitCount = 0;
        int valueCount = 0;

        //initializing deck
        deck = new ArrayList<>();
        for(int ii = 0; ii < 52; ii++)
        {
            deck.add(new CardData(value.get(valueCount), suit.get(suitCount))); //adding values into object
            valueCount++;

            //checks to see if a suit is done
            if(ii == 12 || ii == 25 || ii == 38)
            {
                suitCount++;
                valueCount = 0; //reset value count
            }

        }
    }

    /**
     * The shuffleDeck method shuffles the deck of cards, created from the constructor.
     * Shuffling the deck uses the Collections library.
     */
    public void shuffleDeck(){
        //shuffle 3 times for good shuffle
        for(int ii = 0; ii < 4; ii++)
        {
            Collections.shuffle(deck);
        }
    }

    /**
     * The dealDecks method deals the deck evenly to player 1 and player 2
     */
    public void dealDecks(){
        //initialize player hands
        player1Deck = new ArrayList<>();
        player2Deck = new ArrayList<>();

        for(int ii = 0; ii < 52; ii++)
        {
            //evenly dealing out card
            if(ii % 2 == 0)
            {
                player1Deck.add(deck.get(ii));
            }
            else
            {
                player2Deck.add(deck.get(ii));
            }
        }
    }

    /**
     * The displayHand method takes in the users hand and displays the information of their card at a certain index
     * @param playerHand An ArrayList that holds the players card data
     * @param index The index of the ArrayList to display the data
     */
    public static void displayHand(ArrayList<CardData> playerHand,int index){

        //case padding if players have nothing in hand
        if(playerHand.isEmpty())
        {
            //making sure to check if player hand is empty or not
            System.out.println("There is nothing to display. No cards in hand");
        }
        else
        {
            System.out.print( " Card is ");

            //checks to see if card is a Ace, Queen, King, Jack
            if(playerHand.get(index).getValue() > 10)
            {
                System.out.print(getFaceCard(playerHand, index));
            }
            else
            {
                System.out.print(playerHand.get(index).getValue());
            }

            System.out.println(playerHand.get(index).getSuit());
        }
    }

    /**
     * The getFaceCard method determines if the the value of the card is a face card or not.
     * value of 14 is used as Ace for easier reference to making Ace the highest valued card.
     * @param playerHand An ArrayList of the players cards of a CardData type
     * @param index The position in the ArrayList that is to be evaluated
     * @return a String that represents the value of the card
     */
    public static String getFaceCard(ArrayList<CardData> playerHand, int index){

        //get value of card
        int value = playerHand.get(index).getValue();

        //decision structure of face cards
        switch(value)
        {
            case 11:
            {
                return "Jack";
            }
            case 12:
            {
                return "Queen";
            }
            case 13:
            {
                return "King";
            }
            case 14:
            {
                //Ace value 14 so easier to evaluate highest card
                return "Ace";
            }
            default:
            {
                System.out.println("error in getting face card");
                return "";
            }
        }

    }

    /**
     * The startGame function will start the game of War and end when one player's deck is empty or not enough cards to play
     */
    public void startGame(){
        //initialize player hands
        player1Hand = new ArrayList<>();
        player2Hand = new ArrayList<>();
        boolean player1Continue = true;
        boolean player2Continue = true;

        boolean end = false;
        deckIndex = 0;

        while(!end)
        {
            //placing card to show
            player1Hand.add(player1Deck.get(deckIndex));
            player2Hand.add(player2Deck.get(deckIndex));

            //display their hand
            System.out.print("Player 1 plays");
            displayHand(player1Hand, deckIndex);
            System.out.print("Player 2 plays");
            displayHand(player2Hand, deckIndex);

            if(player1Hand.get(deckIndex).getValue() > player2Hand.get(deckIndex).getValue()) //checking if player 1 card beats player 2
            {
                System.out.println("Player 1 wins the round");
                //giving player 2 card to player 1
                player1Deck.add(player2Hand.get(deckIndex));
                player2Hand.remove(deckIndex);

                player1Deck.add(player1Hand.get(deckIndex));

                player1Hand.remove(deckIndex);
                player2Deck.remove(deckIndex);
                player1Deck.remove(deckIndex);

            }
            else if(player1Hand.get(deckIndex).getValue() < player2Hand.get(deckIndex).getValue()) //checking if player 2 card beats player 1
            {
                System.out.println("Player 2 wins the round");
                //giving player 1 card to player 2
                player2Deck.add(player1Hand.get(deckIndex));
                player1Hand.remove(deckIndex);

                player2Deck.add(player2Hand.get(deckIndex));

                player2Hand.remove(deckIndex);
                player2Deck.remove(deckIndex);
                player1Deck.remove(deckIndex);
            }
            else if(player1Hand.get(deckIndex).getValue() == player2Hand.get(deckIndex).getValue()) //checking if there is war
            {

                boolean endWar = false;
                boolean player1win = false;
                boolean player2win = false;

                int index = 0;

                do{
                    System.out.println("War");

                    //check to see if player has enough cards to play out war
                    if(player1Deck.size() < deckIndex + 5)
                    {
                        player1Continue = false;
                    }
                    else if(player2Deck.size() < deckIndex + 5)
                    {
                        player2Continue = false;
                    }

                    if(player1Continue && player2Continue)
                    {
                        //start dealing war cards
                        startWar();


                        //dealing cards to show
                        player1Hand.add(player1Deck.get(deckIndex));
                        player2Hand.add(player2Deck.get(deckIndex));

                        //display their hand
                        System.out.print("war card for Player 1");
                        displayHand(player1Hand, deckIndex);
                        System.out.print("war card for Player 2");
                        displayHand(player2Hand, deckIndex);

                        if(player1Hand.get(deckIndex).getValue() > player2Hand.get(deckIndex).getValue())
                        {
                            player1win = true;
                            player2win = false;
                            endWar = true;
                        }
                        else if(player1Hand.get(deckIndex).getValue() < player2Hand.get(deckIndex).getValue())
                        {
                            player1win = false;
                            player2win = true;
                            endWar = true;
                        }
                    }
                    else
                    {
                        endWar = true;
                    }



                }while(!endWar);

                //conditions if war was played out, decision who won
                if(player1win)
                {
                    System.out.println("Player 1 wins the war round");

                    while(!(player1Hand.isEmpty()))
                    {
                        //giving player 2 card to player 1
                        player1Deck.add(player2Hand.get(index));
                        player1Deck.add(player1Hand.get(index));

                        player2Hand.remove(index);
                        player1Hand.remove(index);
                        player2Deck.remove(index);
                        player1Deck.remove(index);
                    }
                }
                else if(player2win)
                {
                    System.out.println("Player 2 wins the war round");

                    while(!(player2Hand.isEmpty()))
                    {
                        player2Deck.add(player1Hand.get(index));
                        player1Hand.remove(index);

                        player2Deck.add(player2Hand.get(index));

                        player2Hand.remove(index);
                        player2Deck.remove(index);
                        player1Deck.remove(index);
                    }

                }
            }


            //reset deckIndex back to default
            deckIndex = 0;

            if(!player1Continue || !player2Continue)
            {
                end = true;
            }

            if(player1Deck.isEmpty())
            {
                end = true;
                player1Continue = false;
            }
            else if(player2Deck.isEmpty())
            {
                end = true;
                player2Continue = false;
            }


        }

        //check who won
        if(!player1Continue)
        {
            System.out.println("Player 1 does not have enough cards in deck to play");
            System.out.println("Game over");
            System.out.println("Player 2 wins the game.");
        }
        else if(!player2Continue)
        {
            System.out.println("Player 2 does not have enough cards in deck to play");
            System.out.println("Game over");
            System.out.println("Player 1 wins the game");
        }
    }

    /**
     * The startWar function will deal out three anonymous cards to each players hand and check if players deck is empty
     */
    public static void startWar(){
        //increment deckIndex
        deckIndex++;

        boolean isPlayer1Empty = false, isPlayer2Empty = false;


        //checking if player 1 deck is empty
        if (player1Deck.isEmpty()) {
            isPlayer1Empty = true;
        }
        //checking if player 2 deck is empty
        else if (player2Deck.isEmpty()) {
            isPlayer2Empty = true;
        }

        do {

            player1Hand.add(player1Deck.get(deckIndex));
            player2Hand.add(player2Deck.get(deckIndex));

            System.out.println("War card for player1 card is xx");
            System.out.println("War card for player2 card is xx");


            deckIndex++;

        }while(!isPlayer1Empty && !isPlayer2Empty && deckIndex % 4 != 0);

    }
}