/*
    Daniel Son
    May 4, 2016
    Purpose: The purpose of this program is to work with maps. The program will read a scrabble Q text file.
    The program will then read another text file with a scrabble point system and then input it into a map which will
    then score all the words in the scrabble Q text file.
    Inputs: QWords text file and scrabbleRule text file
    Output: console output
 */
package Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The class Part1Main will get two files: QWords.txt and scrabbleRule.txt. The program will put the scrabbleRules
 * into a map and then point the words in the QWords file.
 */
public class Part1Main {
    private static Scanner file;

    /**
     * The main function is the beginning of the program that will execute the program
     * @param args allows arguments to pass
     */
    public static void main(String[] args){
        Scanner fileQ;
        Map<Character, Integer> map = new HashMap<>();
        try{
            file = new Scanner(new File("src/Collections/scrabbleRule.txt")); //initialize scrabble rule file
            while(file.hasNext()){
                map.put(file.next().charAt(0), Integer.parseInt(file.next())); //put text file into map
            }

            fileQ = new Scanner(new File("src/Collections/QWords.txt")); //initialize QWords text file

            while(fileQ.hasNext()){
                String word = fileQ.nextLine(); //get word from file
                int total = 0; //initialize total point value
                for(int ii = 0; ii < word.length(); ii++){
                    total += map.get(word.charAt(ii)); //go through each character and add point to total
                }
                System.out.println(word + ": " + total); //display in console the total points
            }
        }catch(FileNotFoundException io){
            io.printStackTrace(); //prints error message
        }
        finally{
            file.close(); //closes file
        }
    }
}
