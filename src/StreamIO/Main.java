/*
    Daniel Son
    April 17, 2016
    Purpose: The purpose of Main is to start the program. The Main class will call Menu.
    Inputs:
    Output: A GUI of the main JFrame.
 */

package StreamIO;

import javax.swing.*;

/**
 * The Main class is the beginning of the program.
 */
public class Main {
    /**
     * main function is the start of the whole program.
     * @param args allows arguments to pass
     */
    public static void main(String[] args){
        //creates a new frame using RectangleFrame class properties
        JFrame frame = new Menu();
        //setting frame title.
        frame.setTitle("Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //make frame not resizeable
        frame.setResizable(false);
        //makes frame visible to user
        frame.setVisible(true);
    }
}
