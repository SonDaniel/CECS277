/*
    Daniel Son
    February 23, 2016
    Purpose: The purpose of this program is to retrieve a text file by user and read the text content (the topic and memo)
    Inputs: User will choose the file using a window and user will input a decision to continue reading.
    Output: The topic(s), date(s), and memo(s) contained in the text file.
 */
package fileIO;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class Retriever is designed to get user to feed in a .txt file.
 * The program will then display the text file memo and ask user if they want to keep viewing.
 */
public class Retriever {

    /**
     * Main is the start of the program. Will evoke to user the description of the program.
     * @param args allows arguments to pass.
     */
    public static void main(String[] args)
    {
        System.out.println("This program will retriever multiple memo's in a file. ");
        getFile();
    }

    /**
     * getFile function will allow a window to pop up for user to select the text file.
     * The file will be read and stop just before the next memo.
     * The function will ask user if they would like to continue.
     */
    public static void getFile(){

        //Window for choosing file
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                //initialize objects
                File selectedFile = chooser.getSelectedFile();
                Scanner in = new Scanner(selectedFile);
                Scanner get = new Scanner(System.in);

                boolean cont = true;

                //loop checking if there are still lines to display
                while(in.hasNext() && cont)
                {
                    //displaying lines
                    for(int ii = 0; ii < 4; ii++)
                    {
                        System.out.println(in.nextLine());
                    }

                    //asking user if they want to continue
                    System.out.println("View next memo? [y][n]");
                    System.out.print("choice: ");
                    char decision = get.next().charAt(0);
                    cont = getDecision(decision); //checks to see if user input is valid

                }

                //checks to see if any more lines to display
                if(!in.hasNext())
                {
                    System.out.println("There is no more memo's left to display.");
                }
                System.out.println("Closing Program...");

                //closing Scanners
                in.close();
                get.close();
            }
            catch(FileNotFoundException notFound) //catching error
            {
                notFound.printStackTrace();
            }

        }
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
            System.out.println("Error in decision choice. Choose [y][n]");
            Scanner in = new Scanner(System.in);
            System.out.print("choice: ");
            char decision = in.next().charAt(0);
            return getDecision(decision);
        }
    }
}
