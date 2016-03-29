/*
    Daniel Son
    February 23, 2016
    Purpose: The purpose of this program is to create a text file and allow the user to enter a topic and memo.
    Inputs: The user will input a topic and memo and decision if they want to make another topic and memo
    Output: a text file called memo.txt with user's input of topic(s) and memo(s)
 */
package fileIO;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

/**
 * The class Creator is designed to create a text file called memo.txt and allow user to
 * write a topic and memo. User is asked if they would like to write more until they say no.
 */
public class Creator {
    //Global variables
    private static File file;
    private static PrintWriter output;
    private static boolean again;
    private static Scanner get;
    private static boolean firstTime = true;

    /**
     * Main is the start of the program. It will evoke the description of the program to user.
     * @param args allows arguments to pass
     */
    public static void main(String[] args){
        System.out.println("This program will allow you to create memos.");
        //initializing variables
        get = new Scanner(System.in);
        again = true;

        create();

        //closing Scanner and PrintWriter
        get.close();
        output.close();
    }

    /**
     * The getDecision function will calculate to see what user chooses: y, n or will say error
     * and make user input again.
     * @param choice a character that is given by user
     * @return a boolean of true or false of whether user wants to continue or not
     */
    public static boolean getDecision(char choice){
        if(choice == 'y')
        {
            return true;
        }
        else if(choice == 'n')
        {
            return false;
        }
        else
        {
            System.out.println("Error in decision. Choose [y][n]");
            Scanner in = new Scanner(System.in);
            System.out.print("choice: ");
            char decision = in.next().charAt(0);
            return getDecision(decision);
        }
    }

    /**
     * The create function will allow the user to enter a topic and a memo. It will create and write
     * the data into memo.txt file.
     */
    public static void create(){
        Scanner in = new Scanner(System.in);

        do {

            try
            {
                //if first time running, initialize file
                if(firstTime)
                {
                    file = new File("memo.txt");
                    output = new PrintWriter(file);
                    firstTime = false;

                }
                //getting topic from user
                System.out.print("Topic: ");
                output.println("Topic: " + in.nextLine());

                //writing date into file
                Date date = new Date();
                output.println(date);

                //getting memo from user
                System.out.print("Memo: ");
                output.println("Memo: " + in.nextLine());

                output.println("");

            }
            catch(FileNotFoundException notFound)
            {
                //print error trace
                notFound.printStackTrace();
            }

            //checking to see if user wants to write another
            System.out.println("Do you want to create another memo? [y][n]");
            System.out.print("choice: ");
            char decision = get.next().charAt(0);
            again = getDecision(decision); //checking to see if user input is valid

        }while(again); //loop for user to write multiple topics and memos

    }

}
