/*
    Daniel Son
    March 21, 2016
    Purpose: This class is what starts the program. It will display a window and have a menu where user can change the picture.
            The game is where the user must click the image and gain points.
    Inputs: There is no input in main class.
    Output: The frame of the game.
 */
package GUI;

import javax.swing.*;

/**
 * The main class is used to create the game frame and start the program.
 */
public class Main {
    /**
     * The main method is where the program starts it's execution.
     * @param args allows for arguments input
     */
    public static void main(String[] args){
        //creates a new frame using RectangleFrame class properties
        JFrame frame = new RectangleFrame();
        //setting frame title.
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //makes frame visible to user
        frame.setVisible(true);

    }

}
