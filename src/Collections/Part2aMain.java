/*
    Daniel Son
    May 4, 2016
    Purpose: The purpose of this program is to calculate the speed of using the HashSet. The program will read
    the text file of Alice in Wonderland and add each string into the data set.
    Inputs: Alice text file
    Output: console output
 */
package Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The class Part2aMain is used to observe the speed of using HashSet.
 */
public class Part2aMain {
    private static Scanner file;

    /**
     * The Main function is the start of the program.
     * @param args allows arguments to pass
     */
    public static void main(String[] args){
        try{
            file = new Scanner(new File("src/Collections/alice.txt")); //initialize Alice text file
            Set<String> dataSet = new HashSet<>(); //initialize hashset
            long startTime = System.nanoTime(); //record the start time
            while(file.hasNext()){
                dataSet.add(file.next()); //add string to hashset
            }
            long estimatedTime = System.nanoTime() - startTime; //calculate the timing
            System.out.println("Nano seconds for HashSet: " + estimatedTime); //print out the timing

        }catch(FileNotFoundException io){
            io.printStackTrace(); //print error message
        }finally{
            file.close(); //close file
        }
    }
}
