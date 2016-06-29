/*
    Daniel Son
    May 4, 2016
    Purpose: The purpose of this program is to read a scrabble text file and perform regex on the file
    using different patterns to search for.
    Inputs: scrabble.txt file
    Output: Console text, q.txt file
 */
package RegularExpressions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Main class is the class that will start the program and perform the different tasks
 * of finding different patterns in the scrabble.txt file
 */
public class Main {
    private static Scanner file;
    private static int count;
    private static Pattern p;

    /**
     * The main function is where the program starts and performs the patterns
     * @param args Allows arguments to pass
     */
    public static void main(String[] args){
        try{
            /*----------------Finding all words with two z's in a row ---------------*/
            file = new Scanner(new File("src/RegularExpressions/scrabble.txt"));
            p = Pattern.compile("[z]{2}"); //initialize pattern

            System.out.println("All of the words with two z's in a row.");
            count = 0; //make count to 0
            find(); //call function to perform algorithm
            System.out.println("Regex count match: " + count); //display how many words displayed

            file.close(); //close file

            System.out.println("Press enter to continue.");
            System.in.read();
            /*----------------Finding all words with two vowels in a row ---------------*/
            file = new Scanner(new File("src/RegularExpressions/scrabble.txt")); //reinitialize file
            p = Pattern.compile("[aeiou]{2}"); //initialize different pattern

            System.out.println("All of the words with two vowel's in a row.");
            count = 0; //reset count
            find(); //call algorithm
            System.out.println("Regex count match: " + count);

            file.close();

            System.out.println("Press enter to continue.");
            System.in.read();
            /*----------------Finding all words with more than two vowels in them ---------------*/
            file = new Scanner(new File("src/RegularExpressions/scrabble.txt")); //reinitialize file
            p = Pattern.compile("([aeiou])(.*)([aeiou])(.*)([aeiou])"); //initialize pattern

            System.out.println("All of the words with more than two vowel's.");
            count = 0; //reset count
            find();
            System.out.println("Regex count match: " + count);

            file.close();

            System.out.println("Press enter to continue.");
            System.in.read();
            /*----------------Finding all words with two x's in them ---------------*/
            file = new Scanner(new File("src/RegularExpressions/scrabble.txt"));
            p = Pattern.compile("(x)(.*)\\1");

            System.out.println("All of the words with more than two vowel's.");
            count = 0;
            find();
            System.out.println("Regex count match: " + count);

            file.close();

            System.out.println("Press enter to continue.");
            System.in.read();
            /*----------------Finding all words starting with Q not followed by a 'U' in them ---------------*/
            file = new Scanner(new File("src/RegularExpressions/scrabble.txt"));
            p = Pattern.compile("(\\bq)([^u])");
            PrintWriter output = new PrintWriter("src/RegularExpressions/q.txt");
            System.out.println("All of the words with more than two vowel's.");
            count = 0;
            while(file.hasNext()){
                String fileData = file.next(); //file string data
                Matcher m = p.matcher(fileData); //import string into matcher
                if(m.find()){
                    output.println(fileData); //write to file
                    System.out.println(fileData); //print to console
                    count++; //increment
                }
            }
            System.out.println("Regex count match: " + count);

            file.close();
            output.close();

        }catch(IOException io){
            io.printStackTrace(); //print error message
        }
        finally{
            file.close(); //close file
        }
    }

    /**
     * The find function is the algorithm that checks to see if the words match the pattern
     */
    private static void find(){
        while(file.hasNext()){
            String fileData = file.next(); //file data string
            Matcher m = p.matcher(fileData); //import string into matcher
            if(m.find()){
                System.out.println(fileData); //print to console
                count++; //increment count
            }
        }
    }
}
