/*
    Daniel Son
    May 4, 2016
    Purpose: The purpose of this program is to calculate the speed of using the TreeSet. The program will read
    the text file of Alice in Wonderland and add each string into the data set.
    Inputs: Alice text file
    Output: console output
 */
package Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * The class Part2aMain is used to observe the speed of using HashSet.
 */
public class Part2bMain {
    private static Scanner file;

    /**
     * The Main function is the start of the program.
     * @param args allows arguments to pass
     */
    public static void main(String[] args){
        try{
            file = new Scanner(new File("src/Collections/alice.txt")); //initialize Alice text file
            Set<String> dataSet = new TreeSet<>(); //initialize Tree set
            long startTime = System.nanoTime(); //get start time
            while(file.hasNext()){
                dataSet.add(file.next()); //add string to tree set
            }
            long estimatedTime = System.nanoTime() - startTime; //calculate the time
            System.out.println("Nano seconds for TreeSet: " + estimatedTime); //display on console

        }catch(FileNotFoundException io){
            io.printStackTrace(); //print error message
        }finally{
            file.close(); //close file
        }
    }
}
